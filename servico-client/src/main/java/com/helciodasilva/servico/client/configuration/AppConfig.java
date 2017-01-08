package com.helciodasilva.servico.client.configuration;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

import com.helciodasilva.servico.client.converter.ServicoConverter;

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
	class WebMvcContext extends WebMvcConfigurerAdapter {

		@Autowired
		private ServicoConverter servicoConverter;

		@Override
		public void addFormatters(FormatterRegistry registry) {
			registry.addConverter(servicoConverter);

		}
	}

	@Configuration
	public static class MvcConfig extends WebMvcConfigurerAdapter {

		@Override
		public void addViewControllers(ViewControllerRegistry registry) {
			registry.addRedirectViewController("/", "/empresa");
		}
	}

}
