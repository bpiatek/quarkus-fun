package b.piatek.config;

import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.SqlClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;

/**
 * Created by Bartosz Piatek on 24/06/2023
 */
class SqlClientFactory {

    private final PgPool pool;

    @Inject
    public SqlClientFactory(PgPool pool) {
        this.pool = pool;
    }

    @Produces
    @ApplicationScoped
    SqlClient createClient() {
        return pool;
    }
}
