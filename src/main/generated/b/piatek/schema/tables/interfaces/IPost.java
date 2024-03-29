/*
 * This file is generated by jOOQ.
 */
package b.piatek.schema.tables.interfaces;


import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;

import java.io.Serializable;


import static io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo.*;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public interface IPost extends VertxPojo, Serializable {

    /**
     * Setter for <code>public.post.id</code>.
     */
    public IPost setId(Integer value);

    /**
     * Getter for <code>public.post.id</code>.
     */
    public Integer getId();

    /**
     * Setter for <code>public.post.message</code>.
     */
    public IPost setMessage(String value);

    /**
     * Getter for <code>public.post.message</code>.
     */
    public String getMessage();

    /**
     * Setter for <code>public.post.authorid</code>.
     */
    public IPost setAuthorid(Integer value);

    /**
     * Getter for <code>public.post.authorid</code>.
     */
    public Integer getAuthorid();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common
     * interface IPost
     */
    public void from(IPost from);

    /**
     * Copy data into another generated Record/POJO implementing the common
     * interface IPost
     */
    public <E extends IPost> E into(E into);

        @Override
        public default IPost fromJson(io.vertx.core.json.JsonObject json) {
                setOrThrow(this::setId,json::getInteger,"id","java.lang.Integer");
                setOrThrow(this::setMessage,json::getString,"message","java.lang.String");
                setOrThrow(this::setAuthorid,json::getInteger,"authorid","java.lang.Integer");
                return this;
        }


        @Override
        public default io.vertx.core.json.JsonObject toJson() {
                io.vertx.core.json.JsonObject json = new io.vertx.core.json.JsonObject();
                json.put("id",getId());
                json.put("message",getMessage());
                json.put("authorid",getAuthorid());
                return json;
        }

}
