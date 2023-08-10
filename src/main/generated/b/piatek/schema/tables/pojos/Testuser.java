/*
 * This file is generated by jOOQ.
 */
package b.piatek.schema.tables.pojos;


import b.piatek.schema.tables.interfaces.ITestuser;

import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;


import static io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo.*;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Testuser implements VertxPojo, ITestuser {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String password;
    private String roles;
    private String username;

    public Testuser() {}

    public Testuser(ITestuser value) {
        this.id = value.getId();
        this.password = value.getPassword();
        this.roles = value.getRoles();
        this.username = value.getUsername();
    }

    public Testuser(
        Long id,
        String password,
        String roles,
        String username
    ) {
        this.id = id;
        this.password = password;
        this.roles = roles;
        this.username = username;
    }

        public Testuser(io.vertx.core.json.JsonObject json) {
                this();
                fromJson(json);
        }

    /**
     * Getter for <code>public.testuser.id</code>.
     */
    @Override
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.testuser.id</code>.
     */
    @Override
    public Testuser setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>public.testuser.password</code>.
     */
    @Override
    public String getPassword() {
        return this.password;
    }

    /**
     * Setter for <code>public.testuser.password</code>.
     */
    @Override
    public Testuser setPassword(String password) {
        this.password = password;
        return this;
    }

    /**
     * Getter for <code>public.testuser.roles</code>.
     */
    @Override
    public String getRoles() {
        return this.roles;
    }

    /**
     * Setter for <code>public.testuser.roles</code>.
     */
    @Override
    public Testuser setRoles(String roles) {
        this.roles = roles;
        return this;
    }

    /**
     * Getter for <code>public.testuser.username</code>.
     */
    @Override
    public String getUsername() {
        return this.username;
    }

    /**
     * Setter for <code>public.testuser.username</code>.
     */
    @Override
    public Testuser setUsername(String username) {
        this.username = username;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Testuser other = (Testuser) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.password == null) {
            if (other.password != null)
                return false;
        }
        else if (!this.password.equals(other.password))
            return false;
        if (this.roles == null) {
            if (other.roles != null)
                return false;
        }
        else if (!this.roles.equals(other.roles))
            return false;
        if (this.username == null) {
            if (other.username != null)
                return false;
        }
        else if (!this.username.equals(other.username))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.password == null) ? 0 : this.password.hashCode());
        result = prime * result + ((this.roles == null) ? 0 : this.roles.hashCode());
        result = prime * result + ((this.username == null) ? 0 : this.username.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Testuser (");

        sb.append(id);
        sb.append(", ").append(password);
        sb.append(", ").append(roles);
        sb.append(", ").append(username);

        sb.append(")");
        return sb.toString();
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
    }

    @Override
    public <E extends ITestuser> E into(E into) {
        into.from(this);
        return into;
    }
}
