package b.piatek.post.config;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.apache.commons.lang3.StringUtils;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.HashMap;
import java.util.Map;

@QuarkusTestResource(TestContainersPostgresqlResource.Initializer.class)
public class TestContainersPostgresqlResource {

  public static class Initializer implements QuarkusTestResourceLifecycleManager {

    private PostgreSQLContainer postgreSQLContainer;

    @Override
    public Map<String, String> start() {
      this.postgreSQLContainer = new PostgreSQLContainer<>("postgres");
      this.postgreSQLContainer.start();

      return config();
    }

    private Map<String, String> config() {
      Map<String, String> conf = new HashMap<>();

      String remove = StringUtils.remove(this.postgreSQLContainer.getJdbcUrl(), "jdbc:");
      conf.put("quarkus.datasource.reactive.url", remove);
      conf.put("quarkus.datasource.username", this.postgreSQLContainer.getUsername());
      conf.put("quarkus.datasource.password", this.postgreSQLContainer.getPassword());

      return conf;
    }

    @Override
    public void stop() {
      if (this.postgreSQLContainer != null) {
        this.postgreSQLContainer.stop();
      }
    }
  }
}
