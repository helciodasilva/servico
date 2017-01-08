package com.helciodasilva.servico.api.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

/**
 * Configurações da aplicação.
 * 
 * @author Helcio da Silva
 * @since 07/01/2017
 */
@Configuration
public class AppConfig {

	@Bean
	public LocaleResolver localeResolver() {
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}

	@Configuration
	public static class MvcConfig extends WebMvcConfigurerAdapter {

		@Override
		public void addViewControllers(ViewControllerRegistry registry) {
			registry.addRedirectViewController("/", "/swagger-ui.html");
			registry.addRedirectViewController("/api-doc", "/swagger-ui.html");
		}
	}
}
