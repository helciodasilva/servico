package com.helciodasilva.servico.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.helciodasilva.servico.api.resource.EmpresaResource;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private final String REGEX = loadRestControllers();

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo()).select()
				.apis(RequestHandlerSelectors.any()).paths(PathSelectors.regex(REGEX)).build();
	}

	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder().title(" Gerenciamento de Compras de Serviços")
				.description("Serviço de Gerenciamento de Compras de Serviços").license("Helcio da Silva")
				.licenseUrl("https://github.com/helciodasilva/servico").version("1.0.0").build();
	}

	@Bean
	public PropertySourcesPlaceholderConfigurer swaggerProperties() {
		//Alterando a configuração do Swagger para trabalhar com o Eureka.
		PropertySourcesPlaceholderConfigurer property = new PropertySourcesPlaceholderConfigurer();
		property.setIgnoreUnresolvablePlaceholders(true);
		return property;
	}

	private String loadRestControllers() {
		StringBuilder builder = new StringBuilder();
		builder.append(EmpresaResource.REGEX_MAPPER);
		return builder.toString();
	}

}
