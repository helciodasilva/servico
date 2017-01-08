package com.helciodasilva.servico.client.model;

/**
 * Modelo Servico.
 * 
 * @author Helcio da Silva
 * @since 07/01/2017
 */
public class Servico {

	private Long id;

	private String nome;

	private Double preco;

	public Servico() {
	}

	public Servico(String nome, Double preco) {
		this.nome = nome;
		this.preco = preco;
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
}
