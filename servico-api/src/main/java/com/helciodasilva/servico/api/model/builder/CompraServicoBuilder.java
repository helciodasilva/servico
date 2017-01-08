package com.helciodasilva.servico.api.model.builder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.helciodasilva.servico.api.enums.TipoCliente;
import com.helciodasilva.servico.api.model.Cliente;
import com.helciodasilva.servico.api.model.Compra;
import com.helciodasilva.servico.api.model.Servico;

/**
 * Builder de Compra.
 * 
 * @author Helcio da Silva
 * @since 07/01/2017
 */
public class CompraServicoBuilder {

	private Compra compra = new Compra();

	public CompraServicoBuilder withId(Long id) {
		compra.setId(id);
		return this;
	}

	public CompraServicoBuilder withPreco(double preco) {
		Servico servico = new Servico("Serviço", preco);
		compra.setServico(servico);
		return this;
	}

	public CompraServicoBuilder withTipoCliente(TipoCliente tipoCliente) {
		Cliente cliente = new Cliente();
		cliente.setTipoCliente(tipoCliente);
		return this;
	}

	public CompraServicoBuilder withDataVencimento(LocalDate dataVencimento) {
		String dataFim = dataVencimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		compra.setDataFim(dataFim);
		return this;
	}

	public Compra build() {
		return compra;
	}

}
