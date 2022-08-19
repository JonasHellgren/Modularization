package environment_runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"environment_service/api","environment_runner"})
public class EnvironmentRunnerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnvironmentRunnerApplication.class, args);
	}

}
