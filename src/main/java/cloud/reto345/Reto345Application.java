package cloud.reto345;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"cloud.reto345.model"})
@SpringBootApplication
public class  Reto345Application {

	public static void main(String[] args) {
		SpringApplication.run(Reto345Application.class, args);
	}

}
