package b.piatek.config;

import io.github.jklingsporn.vertx.jooq.mutiny.reactive.ReactiveMutinyGenericQueryExecutor;
import io.vertx.mutiny.sqlclient.SqlClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import org.jooq.Configuration;

/**
 * Created by Bartosz Piatek on 24/06/2023
 */
class QueryExecutorFactory {

    private final SqlClient sqlClient;
    private final Configuration configuration;

    @Inject
    public QueryExecutorFactory(SqlClient sqlClient, Configuration configuration) {
        this.sqlClient = sqlClient;
        this.configuration = configuration;
    }

    @Produces
    @ApplicationScoped
    public ReactiveMutinyGenericQueryExecutor createExecutor(){
        return new ReactiveMutinyGenericQueryExecutor(configuration,sqlClient);
    }
}
