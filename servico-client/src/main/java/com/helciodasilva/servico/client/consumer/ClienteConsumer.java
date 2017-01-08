package com.helciodasilva.servico.client.consumer;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.helciodasilva.servico.client.model.Cliente;

/**
 * Consumir do recurso Cliente.
 * 
 * @author Helcio da Silva
 * @since 07/01/2017
 */
@FeignClient(url = "http://api:8080", value = "cliente")
public interface ClienteConsumer {

	@RequestMapping(method = RequestMethod.GET, value = "cliente")
	public List<Cliente> findAll();

	@RequestMapping(method = RequestMethod.POST, value = "cliente")
	public void save(@RequestBody Cliente cliente);

}
