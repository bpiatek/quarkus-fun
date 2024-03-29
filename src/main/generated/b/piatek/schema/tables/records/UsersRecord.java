/*
 * This file is generated by jOOQ.
 */
package b.piatek.schema.tables.records;


import b.piatek.schema.tables.Users;
import b.piatek.schema.tables.interfaces.IUsers;

import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


import static io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo.*;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UsersRecord extends UpdatableRecordImpl<UsersRecord> implements VertxPojo, Record2<Long, String>, IUsers {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.users.id</code>.
     */
    @Override
    public UsersRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.users.id</code>.
     */
    @Override
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.users.name</code>.
     */
    @Override
    public UsersRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.users.name</code>.
     */
    @Override
    public String getName() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<Long, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<Long, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Users.USERS.ID;
    }

    @Override
    public Field<String> field2() {
        return Users.USERS.NAME;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public UsersRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public UsersRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public UsersRecord values(Long value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IUsers from) {
        setId(from.getId());
        setName(from.getName());
        resetChangedOnNotNull();
    }

    @Override
    public <E extends IUsers> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UsersRecord
     */
    public UsersRecord() {
        super(Users.USERS);
    }

    /**
     * Create a detached, initialised UsersRecord
     */
    public UsersRecord(Long id, String name) {
        super(Users.USERS);

        setId(id);
        setName(name);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised UsersRecord
     */
    public UsersRecord(b.piatek.schema.tables.pojos.Users value) {
        super(Users.USERS);

        if (value != null) {
            setId(value.getId());
            setName(value.getName());
            resetChangedOnNotNull();
        }
    }

        public UsersRecord(io.vertx.core.json.JsonObject json) {
                this();
                fromJson(json);
        }
}
