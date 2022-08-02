import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication //(scanBasePackages = {"com.javatechie.*"})
//Following is used in tutorial but does not work: @ComponentScan  (basePackages = {"com.javatechie.*"})
@ComponentScan (basePackages = "controller.doctor,service.doctor")

//Following is used in tutorial but works anyway
//@EntityScan  (basePackages = "controller.doctor,service.doctor")
//@EnableJpaRepositories  (basePackages = "controller.doctor,service.doctor")
public class HMSApplication {
    public static void main(String[] args) {
        System.out.println("Starting HMS");
        SpringApplication.run(HMSApplication.class, args);
    }
}
