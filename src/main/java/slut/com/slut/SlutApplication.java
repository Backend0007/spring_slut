package slut.com.slut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SlutApplication {

	public static void main(String[] args) {
		SpringApplication.run(SlutApplication.class, args);
	}

}
