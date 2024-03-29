/*
 * This file is generated by jOOQ.
 */
package b.piatek.schema.tables.records;


import b.piatek.schema.tables.Testuser;
import b.piatek.schema.tables.interfaces.ITestuser;

import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


import static io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo.*;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TestuserRecord extends UpdatableRecordImpl<TestuserRecord> implements VertxPojo, Record4<Long, String, String, String>, ITestuser {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.testuser.id</code>.
     */
    @Override
    public TestuserRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.testuser.id</code>.
     */
    @Override
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.testuser.password</code>.
     */
    @Override
    public TestuserRecord setPassword(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.testuser.password</code>.
     */
    @Override
    public String getPassword() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.testuser.roles</code>.
     */
    @Override
    public TestuserRecord setRoles(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.testuser.roles</code>.
     */
    @Override
    public String getRoles() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.testuser.username</code>.
     */
    @Override
    public TestuserRecord setUsername(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.testuser.username</code>.
     */
    @Override
    public String getUsername() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Long, String, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Long, String, String, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Testuser.TESTUSER.ID;
    }

    @Override
    public Field<String> field2() {
        return Testuser.TESTUSER.PASSWORD;
    }

    @Override
    public Field<String> field3() {
        return Testuser.TESTUSER.ROLES;
    }

    @Override
    public Field<String> field4() {
        return Testuser.TESTUSER.USERNAME;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getPassword();
    }

    @Override
    public String component3() {
        return getRoles();
    }

    @Override
    public String component4() {
        return getUsername();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getPassword();
    }

    @Override
    public String value3() {
        return getRoles();
    }

    @Override
    public String value4() {
        return getUsername();
    }

    @Override
    public TestuserRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public TestuserRecord value2(String value) {
        setPassword(value);
        return this;
    }

    @Override
    public TestuserRecord value3(String value) {
        setRoles(value);
        return this;
    }

    @Override
    public TestuserRecord value4(String value) {
        setUsername(value);
        return this;
    }

    @Override
    public TestuserRecord values(Long value1, String value2, String value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(ITestuser from) {
        setId(from.getId());
        setPassword(from.getPassword());
        setRoles(from.getRoles());
        setUsername(from.getUsername());
        resetChangedOnNotNull();
    }

    @Override
    public <E extends ITestuser> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TestuserRecord
     */
    public TestuserRecord() {
        super(Testuser.TESTUSER);
    }

    /**
     * Create a detached, initialised TestuserRecord
     */
    public TestuserRecord(Long id, String password, String roles, String username) {
        super(Testuser.TESTUSER);

        setId(id);
        setPassword(password);
        setRoles(roles);
        setUsername(username);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised TestuserRecord
     */
    public TestuserRecord(b.piatek.schema.tables.pojos.Testuser value) {
        super(Testuser.TESTUSER);

        if (value != null) {
            setId(value.getId());
            setPassword(value.getPassword());
            setRoles(value.getRoles());
            setUsername(value.getUsername());
            resetChangedOnNotNull();
        }
    }

        public TestuserRecord(io.vertx.core.json.JsonObject json) {
                this();
                fromJson(json);
        }
}
