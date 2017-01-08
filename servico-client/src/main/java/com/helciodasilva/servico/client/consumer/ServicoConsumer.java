package com.helciodasilva.servico.client.consumer;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.helciodasilva.servico.client.model.Servico;

/**
 * Consumir do recurso Empresa.
 * 
 * @author Helcio da Silva
 * @since 07/01/2017
 */
@FeignClient(url = "http://api:8080", value = "servico")
public interface ServicoConsumer {

	@RequestMapping(value = "servico", method = RequestMethod.GET)
	public List<Servico> findAll();

	@RequestMapping(value = "servico", method = RequestMethod.POST)
	public void save(@RequestBody Servico servico);
}
