package com.ty.wellness_care.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class WellnessCareConfiguration {

	@Bean
	public Docket getDocket() {
		
		Contact contact=new Contact("WellnessCare","https://Wellnesscare.com/","startechies@ty.com");
		
		List<VendorExtension> extensions=new ArrayList<VendorExtension>();
		
		ApiInfo apiInfo=new ApiInfo("Wellness_care Api Document",
				"Project for patient's appointment with doctors,labs and medication", 
			     "TYP-Wellnesscare-project-Sanpshot -1.0.1",
			     "https://Wellnesscare.com/",
			     contact,
			     "license 1101", 
			     "https://Wellnesscare.com/",
			     extensions);
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ty.wellness_care"))
				.build()
		        .apiInfo(apiInfo)
		        .useDefaultResponseMessages(false);
	}

}
