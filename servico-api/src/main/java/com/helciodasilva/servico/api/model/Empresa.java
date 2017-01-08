package com.helciodasilva.servico.api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Entidade Empresa.
 * 
 * @author Helcio da Silva
 * @since 07/01/2017
 */
@Entity(name = "empresa")
public class Empresa {

	@Id
	@GeneratedValue
	private Long id;

	private String nome;

	@ManyToMany
	private List<Cliente> clientes;

	@ManyToMany
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
