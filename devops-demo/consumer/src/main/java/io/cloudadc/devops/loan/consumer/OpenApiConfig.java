package io.cloudadc.devops.loan.consumer;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
	
	public OpenAPI customOpenAPI() {
	    return (new OpenAPI()).components(new Components())
	      .info((new Info()).title("Loan API").description("This is Loan Application API"));
	  }

}
