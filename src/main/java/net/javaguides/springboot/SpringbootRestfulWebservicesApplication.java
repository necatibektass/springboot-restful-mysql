package net.javaguides.springboot;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info (
				title = "Spring Boot REST API Documentation",
				version = "v1.0",
				description = "Spring Boot REST API Documentation",
				contact = @Contact(
						name = "Necati",
						email = "necati.bektas@rasyona.com",
						url = "https://www.rasyona.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.rasyona.com/license"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Spring Boot User Management REST API Documentation",
				url = "https://www.rasyona.com"
		)
)
public class SpringbootRestfulWebservicesApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfulWebservicesApplication.class, args);
	}

}
