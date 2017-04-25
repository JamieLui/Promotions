package com.jamie;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@EnableSwagger2
@SpringBootApplication
public class PromotionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PromotionsApplication.class, args);
	}

	@Bean
	public Docket api(@Value("${swagger.enabled:false}") Boolean swaggerEnabled) {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.build()
				.enable(swaggerEnabled)
				.apiInfo(new ApiInfo("Jamie Lui Checkout Service",
						"A collection of endpoints simulate checkout basket with promotions such as multi-buy", ""
						, "", new Contact("", "", ""), "", ""));
	}
}
