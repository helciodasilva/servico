package com.helciodasilva.servico.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helciodasilva.servico.api.model.Compra;
import com.helciodasilva.servico.api.repository.CompraRepository;

/**
 * Serviço Compra.
 * 
 * @author Helcio da Silva
 * @since 07/01/2017
 */
@Service
public class CompraService {

	@Autowired
	private CompraRepository compraRepository;

	public Compra findOne(Long id) {
		return compraRepository.findOne(id);
	}

	public void save(Compra compra) {
		compraRepository.save(compra);
	}
}
