package com.helciodasilva.servico.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Entidade Compra.
 * 
 * @author Helcio da Silva
 * @since 07/01/2017
 */
@Entity(name = "compraservico")
public class Compra {

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne
	private Servico servico;

	private String dataInicio;

	private String dataFim;

	private boolean paga;

	public Compra() {
	}

	public Compra(Servico servico, String dataInicio, String dataFim, boolean paga) {
		this.servico = servico;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.paga = paga;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	public boolean isPaga() {
		return paga;
	}

	public void setPaga(boolean paga) {
		this.paga = paga;
	}

}
