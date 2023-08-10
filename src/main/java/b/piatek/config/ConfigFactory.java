package b.piatek.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.jooq.Configuration;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultConfiguration;

/**
 * Created by Bartosz Piatek on 24/06/2023
 */
class ConfigFactory {

    @Produces
    @ApplicationScoped
    public Configuration createContext(){
        Configuration configuration = new DefaultConfiguration();
        configuration.set(SQLDialect.POSTGRES);
        return configuration;
    }
}
