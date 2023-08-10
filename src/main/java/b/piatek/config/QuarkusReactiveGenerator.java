package b.piatek.config;

import io.github.jklingsporn.vertx.jooq.generate.builder.DelegatingVertxGenerator;
import io.github.jklingsporn.vertx.jooq.generate.builder.PredefinedNamedInjectionStrategy;
import io.github.jklingsporn.vertx.jooq.generate.builder.VertxGeneratorBuilder;

/**
 * Created by Bartosz Piatek on 24/06/2023
 */
public class QuarkusReactiveGenerator extends DelegatingVertxGenerator {
    public QuarkusReactiveGenerator() {
        super(VertxGeneratorBuilder
                .init()
                .withMutinyAPI()
                .withPostgresReactiveDriver()
                .withGuice(false, PredefinedNamedInjectionStrategy.DISABLED)
                .build());
    }
}
