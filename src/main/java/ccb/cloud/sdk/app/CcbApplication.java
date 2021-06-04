package ccb.cloud.sdk.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
@ComponentScan(basePackages = {"ccb.cloud.sdk"})
public class CcbApplication {
    public static void main(String[] args) {
        SpringApplication.run(CcbApplication.class, args);
    }
}
