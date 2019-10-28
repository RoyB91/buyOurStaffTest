package com.codecool.shop.dao.implementation.jdbc;

import com.codecool.shop.dao.*;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import com.codecool.shop.util.Error;
import lombok.Cleanup;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoJDBC extends DaoJDBC implements ProductDao {

    @Override
    public void add(Product product) {
        String query = "INSERT INTO product (name, supplier_id, product_category_id," +
                " default_price, default_currency, description) " +
                "VALUES (?, ?, ?, ?, ?, ?) RETURNING id;";

        try {
            @Cleanup Connection conn = getConnection();
            @Cleanup PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getSupplier().getId());
            stmt.setInt(3, product.getProductCategory().getId());
            stmt.setBigDecimal(4, product.getDefaultPrice());
            stmt.setString(5, product.getDefaultCurrency().getCurrencyCode());
            stmt.setString(6, product.getDescription());
            @Cleanup ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                product.setId(id);
            } else {
                throw new DataNotFoundException(Error.NO_PRODUCT_ID);
            }
        } catch (SQLException e) {
            throw new DataSourceException(Error.DATABASE_IS_UNREACHABLE, e);
        }
    }

    @Override
    public Product find(int id) {
        String query = "SELECT * FROM product WHERE id = " + id + ";";

        try {
            @Cleanup Connection conn = getConnection();
            @Cleanup Statement stmt = conn.createStatement();
            @Cleanup ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                Product product = createProduct(rs);
                product.setId(id);
                return product;
            }
        } catch (SQLException e) {
            throw new DataSourceException(Error.DATABASE_IS_UNREACHABLE, e);
        }

        throw new DataNotFoundException(Error.NO_SUCH_PRODUCT);
    }

    @Override
    public void remove(int id) {
        String query = "DELETE FROM product WHERE id = " + id + ";";

        try {
            @Cleanup Connection conn = getConnection();
            @Cleanup Statement stmt = conn.createStatement();

            stmt.execute(query);
        } catch (SQLException e) {
            throw new DataSourceException(Error.DATABASE_IS_UNREACHABLE, e);
        }
    }

    @Override
    public List<Product> getAll() {
        String query = "SELECT * FROM product;";

        try {
            return createProductList(query);
        } catch (SQLException e) {
            throw new DataSourceException(Error.DATABASE_IS_UNREACHABLE, e);
        }
    }

    @Override
    public List<Product> getBy(Supplier supplier) {
        int supplierId = supplier.getId();
        String query = "SELECT * FROM product WHERE supplier_id = " + supplierId + ";";

        try {
            return createProductList(query);
        } catch (SQLException e) {
            throw new DataSourceException(Error.DATABASE_IS_UNREACHABLE, e);
        }
    }


    @Override
    public List<Product> getBy(ProductCategory productCategory) {
        int productCategoryId = productCategory.getId();
        String query = "SELECT * FROM product WHERE product_category_id = " + productCategoryId + ";";

        try {
            return createProductList(query);
        } catch (SQLException e) {
            throw new DataSourceException(Error.DATABASE_IS_UNREACHABLE, e);
        }
    }

    private Product createProduct(ResultSet rs) throws SQLException {
        ProductCategoryDao productCategoryDao = DaoController.getProductCategoryDao();
        SupplierDao supplierDao = DaoController.getSupplierDao();

        String name = rs.getString("name");
        String description = rs.getString("description");
        int productCategoryId = rs.getInt("product_category_id");
        int supplierId = rs.getInt("supplier_id");
        BigDecimal defaultPrice = rs.getBigDecimal("default_price");
        String defaultCurrency = rs.getString("default_currency");

        Supplier supplier = supplierDao.find(supplierId);
        ProductCategory productCategory = productCategoryDao.find(productCategoryId);

        return new Product(name, defaultPrice,
                defaultCurrency, description, productCategory, supplier);
    }

    private List<Product> createProductList(String query) throws SQLException {
        List<Product> result = new ArrayList<>();

        @Cleanup Connection conn = getConnection();
        @Cleanup Statement stmt = conn.createStatement();
        @Cleanup ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            int id = rs.getInt("id");
            Product product = createProduct(rs);
            product.setId(id);
            result.add(product);
        }
        return result;
    }
}
