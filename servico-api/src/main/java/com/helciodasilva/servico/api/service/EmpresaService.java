package com.helciodasilva.servico.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helciodasilva.servico.api.model.Empresa;
import com.helciodasilva.servico.api.repository.EmpresaRepository;

/**
 * Serviço Empresa.
 * 
 * @author Helcio da Silva
 * @since 07/01/2017
 */
@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;

	public Empresa findOne(Long id) {
		return empresaRepository.findOne(id);
	}

	public List<Empresa> findAll() {
		return empresaRepository.findAll();
	}

	public void save(Empresa empresa) {
		empresaRepository.save(empresa);
	}
}