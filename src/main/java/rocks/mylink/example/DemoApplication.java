package rocks.mylink.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBootApplication adds the following annotations:
 *  - @configuration
 *  - @EnableAutoConfiguration
 *  - @ComponentScan
 */

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
