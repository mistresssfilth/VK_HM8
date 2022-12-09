/*
 * This file is generated by jOOQ.
 */
package generated;


import generated.tables.Company;
import generated.tables.FlywaySchemaHistory;
import generated.tables.Product;
import generated.tables.records.CompanyRecord;
import generated.tables.records.FlywaySchemaHistoryRecord;
import generated.tables.records.ProductRecord;

import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<CompanyRecord> COMPANY_PK = Internal.createUniqueKey(Company.COMPANY, DSL.name("company_pk"), new TableField[] { Company.COMPANY.NAME }, true);
    public static final UniqueKey<FlywaySchemaHistoryRecord> FLYWAY_SCHEMA_HISTORY_PK = Internal.createUniqueKey(FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, DSL.name("flyway_schema_history_pk"), new TableField[] { FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_RANK }, true);
    public static final UniqueKey<ProductRecord> INVOICES_PK = Internal.createUniqueKey(Product.PRODUCT, DSL.name("invoices_pk"), new TableField[] { Product.PRODUCT.ID }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<ProductRecord, CompanyRecord> PRODUCT__PRODUCT_COMPANY_NAME_FKEY = Internal.createForeignKey(Product.PRODUCT, DSL.name("product_company_name_fkey"), new TableField[] { Product.PRODUCT.COMPANY_NAME }, Keys.COMPANY_PK, new TableField[] { Company.COMPANY.NAME }, true);
}
