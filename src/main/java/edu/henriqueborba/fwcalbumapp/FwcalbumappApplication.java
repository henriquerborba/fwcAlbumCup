package edu.henriqueborba.fwcalbumapp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(title = "Fifa World Cup Album API", version = "3.0.1", description = "API para gerenciamento de figurinhas do album da copa"),
		servers = {
				@Server(url = "http://localhost:8080")
		}
)
@SecurityScheme(name = "bearerAuth", scheme = "Bearer", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class FwcalbumappApplication {

	public static void main(String[] args) {
		SpringApplication.run(FwcalbumappApplication.class, args);
	}

}
