package com.helciodasilva.servico.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helciodasilva.servico.api.model.Cliente;
import com.helciodasilva.servico.api.repository.ClienteRepository;

/**
 * Serviço Cliente.
 * 
 * @author Helcio da Silva
 * @since 07/01/2017
 */
@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente findOne(Long id) {
		return clienteRepository.findOne(id);
	}

	public void save(Cliente cliente) {
		clienteRepository.save(cliente);
	}
}
