/*
 * This file is generated by jOOQ.
 */
package generated.tables.records;


import generated.tables.Product;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ProductRecord extends UpdatableRecordImpl<ProductRecord> implements Record4<Integer, String, String, Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.product.id</code>.
     */
    public ProductRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.product.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.product.name</code>.
     */
    public ProductRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.product.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.product.company_name</code>.
     */
    public ProductRecord setCompanyName(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.product.company_name</code>.
     */
    public String getCompanyName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.product.amount</code>.
     */
    public ProductRecord setAmount(Integer value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.product.amount</code>.
     */
    public Integer getAmount() {
        return (Integer) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, String, String, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Integer, String, String, Integer> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Product.PRODUCT.ID;
    }

    @Override
    public Field<String> field2() {
        return Product.PRODUCT.NAME;
    }

    @Override
    public Field<String> field3() {
        return Product.PRODUCT.COMPANY_NAME;
    }

    @Override
    public Field<Integer> field4() {
        return Product.PRODUCT.AMOUNT;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public String component3() {
        return getCompanyName();
    }

    @Override
    public Integer component4() {
        return getAmount();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public String value3() {
        return getCompanyName();
    }

    @Override
    public Integer value4() {
        return getAmount();
    }

    @Override
    public ProductRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public ProductRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public ProductRecord value3(String value) {
        setCompanyName(value);
        return this;
    }

    @Override
    public ProductRecord value4(Integer value) {
        setAmount(value);
        return this;
    }

    @Override
    public ProductRecord values(Integer value1, String value2, String value3, Integer value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ProductRecord
     */
    public ProductRecord() {
        super(Product.PRODUCT);
    }

    /**
     * Create a detached, initialised ProductRecord
     */
    public ProductRecord(Integer id, String name, String companyName, Integer amount) {
        super(Product.PRODUCT);

        setId(id);
        setName(name);
        setCompanyName(companyName);
        setAmount(amount);
    }

    /**
     * Create a detached, initialised ProductRecord
     */
    public ProductRecord(generated.tables.pojos.Product value) {
        super(Product.PRODUCT);

        if (value != null) {
            setId(value.getId());
            setName(value.getName());
            setCompanyName(value.getCompanyName());
            setAmount(value.getAmount());
        }
    }
}
