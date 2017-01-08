package com.helciodasilva.servico.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helciodasilva.servico.client.consumer.ClienteConsumer;
import com.helciodasilva.servico.client.model.Cliente;

/**
 * Serviço Cliente.
 * 
 * @author Helcio da Silva
 * @since 07/01/2017
 */
@Service
public class ClienteService {

	@Autowired
	private ClienteConsumer clienteConsumer;

	public List<Cliente> findAll() {
		return clienteConsumer.findAll();
	}

	public void save(Cliente cliente) {
		clienteConsumer.save(cliente);
	}
}
