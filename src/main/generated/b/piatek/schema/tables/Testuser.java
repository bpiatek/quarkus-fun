/*
 * This file is generated by jOOQ.
 */
package b.piatek.schema.tables;


import b.piatek.schema.Keys;
import b.piatek.schema.Public;
import b.piatek.schema.tables.records.TestuserRecord;

import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function4;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row4;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Testuser extends TableImpl<TestuserRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.testuser</code>
     */
    public static final Testuser TESTUSER = new Testuser();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TestuserRecord> getRecordType() {
        return TestuserRecord.class;
    }

    /**
     * The column <code>public.testuser.id</code>.
     */
    public final TableField<TestuserRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.testuser.password</code>.
     */
    public final TableField<TestuserRecord, String> PASSWORD = createField(DSL.name("password"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.testuser.roles</code>.
     */
    public final TableField<TestuserRecord, String> ROLES = createField(DSL.name("roles"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.testuser.username</code>.
     */
    public final TableField<TestuserRecord, String> USERNAME = createField(DSL.name("username"), SQLDataType.VARCHAR(255), this, "");

    private Testuser(Name alias, Table<TestuserRecord> aliased) {
        this(alias, aliased, null);
    }

    private Testuser(Name alias, Table<TestuserRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.testuser</code> table reference
     */
    public Testuser(String alias) {
        this(DSL.name(alias), TESTUSER);
    }

    /**
     * Create an aliased <code>public.testuser</code> table reference
     */
    public Testuser(Name alias) {
        this(alias, TESTUSER);
    }

    /**
     * Create a <code>public.testuser</code> table reference
     */
    public Testuser() {
        this(DSL.name("testuser"), null);
    }

    public <O extends Record> Testuser(Table<O> child, ForeignKey<O, TestuserRecord> key) {
        super(child, key, TESTUSER);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<TestuserRecord> getPrimaryKey() {
        return Keys.TESTUSER_PKEY;
    }

    @Override
    public Testuser as(String alias) {
        return new Testuser(DSL.name(alias), this);
    }

    @Override
    public Testuser as(Name alias) {
        return new Testuser(alias, this);
    }

    @Override
    public Testuser as(Table<?> alias) {
        return new Testuser(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Testuser rename(String name) {
        return new Testuser(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Testuser rename(Name name) {
        return new Testuser(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Testuser rename(Table<?> name) {
        return new Testuser(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<Long, String, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function4<? super Long, ? super String, ? super String, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function4<? super Long, ? super String, ? super String, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
