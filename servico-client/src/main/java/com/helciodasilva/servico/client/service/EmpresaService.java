package com.helciodasilva.servico.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helciodasilva.servico.client.consumer.EmpresaConsumer;
import com.helciodasilva.servico.client.model.Cliente;
import com.helciodasilva.servico.client.model.Compra;
import com.helciodasilva.servico.client.model.Empresa;
import com.helciodasilva.servico.client.model.Servico;

/**
 * Serviço Empresa.
 * 
 * @author Helcio da Silva
 * @since 07/01/2017
 */
@Service
public class EmpresaService {

	@Autowired
	private EmpresaConsumer empresaConsumer;

	public List<Empresa> findAll() {
		return empresaConsumer.findAll();
	}

	public Empresa findOne(Long id) {
		return empresaConsumer.findOne(id);
	}

	public void addCliente(Long id, Cliente cliente) {
		empresaConsumer.addCliente(id, cliente);
	}

	public Servico findServico(Long id) {
		return empresaConsumer.findServico(id);
	}

	public void addServico(Long id, Servico servico) {
		empresaConsumer.addServico(id, servico);
	}

	public Cliente findCliente(Long id) {
		return empresaConsumer.findCliente(id);
	}

	public void adquirirServico(Long id, Compra compra) {
		empresaConsumer.adquirirServico(id, compra);
	}

	public void pagarServico(Long idCliente, Long idCompra) {
		empresaConsumer.pagarServico(idCliente, idCompra);
	}

	public void salvar(Empresa empresa) {
		empresaConsumer.salvar(empresa);

	}
}