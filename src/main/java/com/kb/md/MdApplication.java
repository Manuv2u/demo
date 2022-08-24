package com.kb.md;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.Contact;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableSwagger2
public class MdApplication {

	public static void main(String[] args) {
		SpringApplication.run(MdApplication.class, args);
	}

	@Bean
	public Docket getDocket() {
		Contact c = new Contact("shubham", "www.kanilebutte.com", "shubham.lokhande@kanilebutte.com");
		List<VendorExtension> e = new ArrayList<VendorExtension>();
		ApiInfo apiInfo = new ApiInfo("car tyre api", "Service to manage car tyre ", "SNPSHOT 1.8",
				"www.kanilebutte.com", c, "License 1304", "www.kanilebutte.com", e);
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.kb"))
				.build().apiInfo(apiInfo).useDefaultResponseMessages(false);
	}

}
