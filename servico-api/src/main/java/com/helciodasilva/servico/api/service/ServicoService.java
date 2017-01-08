package com.helciodasilva.servico.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helciodasilva.servico.api.model.Servico;
import com.helciodasilva.servico.api.repository.ServicoRepository;

/**
 * Serviço Servico.
 * 
 * @author Helcio da Silva
 * @since 07/01/2017
 */
@Service
public class ServicoService {

	@Autowired
	private ServicoRepository servicoRepository;

	public Servico findOne(Long id) {
		return servicoRepository.findOne(id);
	}

	public List<Servico> findAll() {
		return servicoRepository.findAll();
	}

	public void save(Servico servico) {
		servicoRepository.save(servico);
	}
}
