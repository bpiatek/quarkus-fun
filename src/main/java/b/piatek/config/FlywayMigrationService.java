package b.piatek.config;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.flywaydb.core.Flyway;

/**
 * Created by Bartosz Piatek on 28/05/2023
 */
@ApplicationScoped
class FlywayMigrationService {
    private final String dbUrl;
    private final String dbUsername;
    private final String dbPassword;

    public FlywayMigrationService(
        @ConfigProperty(name = "quarkus.datasource.reactive.url") String dbUrl,
        @ConfigProperty(name = "quarkus.datasource.username") String dbUsername,
        @ConfigProperty(name = "quarkus.datasource.password") String dbPassword) {
        this.dbUrl = dbUrl;
        this.dbUsername = dbUsername;
        this.dbPassword = dbPassword;
    }

    public void runFlywayMigration(@Observes StartupEvent event) {
        Flyway flyway = Flyway.configure()
            .dataSource("jdbc:" + dbUrl, dbUsername, dbPassword)
            .load();

        flyway.migrate();
    }
}
