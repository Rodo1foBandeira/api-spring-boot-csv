package APIGet.APIGet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "model")
@EnableJpaRepositories(basePackages = "repo")
public class ApiGetApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGetApplication.class, args);
	}

}
