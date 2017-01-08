package com.helciodasilva.servico.api.enums;

/**
 * Enum utilizado para classificar os tipos de Clientes.
 * 
 * @author Helcio da Silva
 * @since 07/01/2017
 */
public enum TipoCliente {

	OURO("Ouro", 0.9), 
	PRATA("Prata", 0.95);

	private final double desconto;

	private final String descricao;

	private TipoCliente(String descricao, double desconto) {
		this.descricao = descricao;
		this.desconto = desconto;
	}

	public double getDesconto() {
		return desconto;
	}

	public String getDescricao() {
		return descricao;
	}
}
