package environment_runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"dummy"})
public class TestRunner {

    public static void main(String[] args) {
        SpringApplication.run(TestRunner.class, args);
    }
}
