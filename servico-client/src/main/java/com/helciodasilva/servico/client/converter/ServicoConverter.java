package com.helciodasilva.servico.client.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.helciodasilva.servico.client.model.Servico;
import com.helciodasilva.servico.client.service.EmpresaService;

/**
 * Converter de Servico.
 * 
 * @author Helcio da Silva
 * @since 07/01/2017
 */
@Component
public final class ServicoConverter implements Converter<String, Servico> {

	@Autowired
	private EmpresaService empresaService;

	@Override
	public Servico convert(String id) {
		if (id == null || id.isEmpty()) {
			return null;
		}
		return empresaService.findServico(Long.parseLong(id));
	}

}