package com.helciodasilva.servico.client.model;

import java.util.List;

/**
 * Modelo Empresa.
 * 
 * @author Helcio da Silva
 * @since 07/01/2017
 */
public class Empresa {

	private Long id;

	private String nome;

	private List<Cliente> clientes;

	private List<Servico> servicos;

	public Empresa() {
	}

	public Empresa(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

}
