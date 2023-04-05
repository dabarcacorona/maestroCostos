package cl.corona.maestroCostos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MaestroCostosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaestroCostosApplication.class, args);
	}

}
