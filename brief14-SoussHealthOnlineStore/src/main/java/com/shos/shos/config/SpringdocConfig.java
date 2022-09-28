package com.shos.shos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SpringdocConfig {
	@Bean
	public OpenAPI springShopOpenAPI() {
		return new OpenAPI()
				.components(new Components().addSecuritySchemes("bearerAuth",
						new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer")))
				.info(new Info().title("SHOS API").description("Souss Health Online Store API").version("v0.0.1")
						.license(new License().name("Apache 2.0").url("http://springdoc.org"))
						.description("This is the Free Open Source Souss Health Online Store API ")
						.contact(new Contact().email("contact@anmoon.ma").url("http://anmoon.ma")));
	}

}
