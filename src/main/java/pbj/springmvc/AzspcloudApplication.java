package pbj.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("pbj.springmvc")
public class AzspcloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(AzspcloudApplication.class, args);
	}

}
