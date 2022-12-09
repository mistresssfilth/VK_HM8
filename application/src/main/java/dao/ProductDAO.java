package dao;

import commons.JDBCCredentials;
import entity.Product;
import generated.tables.records.ProductRecord;
import org.jetbrains.annotations.NotNull;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static generated.tables.Product.PRODUCT;

public class ProductDAO {
    private @NotNull Connection connection;
    private @NotNull DSLContext context;
    private static final JDBCCredentials CREDS = JDBCCredentials.DEFAULT;

    public ProductDAO() {
        try {
            this.connection = DriverManager.getConnection(CREDS.getUrl(), CREDS.getLogin(), CREDS.getPassword());
            this.context = DSL.using(connection, SQLDialect.POSTGRES);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(@NotNull Product entity) {
        context
                .insertInto(PRODUCT, PRODUCT.ID, PRODUCT.NAME, PRODUCT.COMPANY_NAME, PRODUCT.AMOUNT)
                .values(entity.getId(), entity.getName(), entity.getCompanyName(), entity.getAmount())
                .execute();
    }
    public @NotNull List<Product> getAll() {
        final List<Product> products = new ArrayList<>();
        final Result<ProductRecord> records = context.fetch(PRODUCT);
        for (var record : records) {
            products.add(new Product(
                    record.getId(),
                    record.getName(),
                    record.getCompanyName(),
                    record.getAmount()
            ));
        }
        return products;
    }
    public boolean delete(String productName){
        int i = context
                .deleteFrom(PRODUCT)
                .where(PRODUCT.NAME.eq(productName))
                .execute();
        return i > 0;

    }
    public List<Product> getProductsByCompany(String companyName){

        return context
                .selectFrom(PRODUCT)
                .where(PRODUCT.COMPANY_NAME.eq(companyName))
                .fetchInto(Product.class);
    }
}
