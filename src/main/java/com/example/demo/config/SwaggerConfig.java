package com.example.demo.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Slf4j
public class SwaggerConfig {

	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)//
				.select()//
				.apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))//
				.paths(PathSelectors.regex("/.*"))//
				.build()//
				.apiInfo(metadata())//
				.useDefaultResponseMessages(false)//
				.securitySchemes(new ArrayList<>(Arrays.asList(new ApiKey("Bearer %token", "Authorization", "Header"))))//
				.tags(new Tag("users", "Operations about users"))//
				.tags(new Tag("ping", "Just a ping"))//
				.genericModelSubstitutes(Optional.class);

	}

	  private ApiInfo metadata() {
	    return new ApiInfoBuilder()//
	        .title("JSON Web Token Authentication API")//
	        .description(
	            "This is a sample JWT authentication service. You can find out more about JWT at [https://jwt.io/](https://jwt.io/). For this sample, you can use the `admin` or `client` users (password: admin and client respectively) to test the authorization filters. Once you have successfully logged in and obtained the token, you should click on the right top button `Authorize` and introduce it with the prefix \"Bearer \".")//
	        .version("1.0.0")//
	        .license("MIT License").licenseUrl("http://opensource.org/licenses/MIT")//
	        .contact(new Contact(null, null, "yasoda.yks@gmail.com"))//
	        .build();
	  }
	
	/*
	 * @Bean public Docket swaggerSpringfoxDocket() { log.debug("Starting Swagger");
	 * Contact contact = new Contact( "Yasoda", "", "yasoda.yks@gmail.com");
	 * 
	 * List<VendorExtension> vext = new ArrayList<>(); ApiInfo apiInfo = new
	 * ApiInfo( "Demo API", "Demo - API", "1.0", "", contact, "", "", vext);
	 * 
	 * Docket docket = new Docket(DocumentationType.SWAGGER_2) .apiInfo(apiInfo)
	 * .pathMapping("/") .apiInfo(ApiInfo.DEFAULT) .forCodeGeneration(true)
	 * .genericModelSubstitutes(ResponseEntity.class)
	 * .ignoredParameterTypes(Pageable.class)
	 * .ignoredParameterTypes(java.sql.Date.class)
	 * .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
	 * .directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
	 * .directModelSubstitute(java.time.LocalDateTime.class, Date.class)
	 * .securityContexts(Lists.newArrayList(securityContext()))
	 * .securitySchemes(Lists.newArrayList(apiKey()))
	 * .useDefaultResponseMessages(false);
	 * 
	 * docket = docket.select() .paths(PathSelectors.regex("/api/.*")).build();
	 * 
	 * log.debug("Started Swagger in {} ms", System.currentTimeMillis()); return
	 * docket; }
	 * 
	 * 
	 * private ApiKey apiKey() { return new ApiKey("JWT", "Authorization",
	 * "header"); }
	 * 
	 * private SecurityContext securityContext() { return SecurityContext.builder()
	 * .securityReferences(defaultAuth()) .forPaths(PathSelectors.regex("/api/.*"))
	 * .build(); }
	 * 
	 * List<SecurityReference> defaultAuth() { AuthorizationScope authorizationScope
	 * = new AuthorizationScope("global", "accessEverything"); AuthorizationScope[]
	 * authorizationScopes = new AuthorizationScope[1]; authorizationScopes[0] =
	 * authorizationScope; return Lists.newArrayList( new SecurityReference("JWT",
	 * authorizationScopes)); }
	 */
}
	
	

