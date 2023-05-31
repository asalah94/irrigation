package gov.irrigation.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

	@Bean
	public GroupedOpenApi operationApi() {
		String[] packagesToScan = { "gov.irrigation.controllers" };
		return GroupedOpenApi.builder().group("Common APIs")
				.packagesToScan(packagesToScan).build();
	}


}