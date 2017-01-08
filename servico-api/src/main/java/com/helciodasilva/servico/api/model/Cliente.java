package com.helciodasilva.servico.api.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.helciodasilva.servico.api.enums.TipoCliente;

/**
 * Entidade Cliente.
 * 
 * @author Helcio da Silva
 * @since 07/01/2017
 */
@Entity(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue
	private Long id;

	private String nome;

	@OneToMany
	private List<Compra> compras;

	@Enumerated(EnumType.STRING)
	private TipoCliente tipoCliente;

	public Cliente() {
	}

	public Cliente(String nome, List<Compra> compras, TipoCliente tipoCliente) {
		this.nome = nome;
		this.compras = compras;
		this.tipoCliente = tipoCliente;
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

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	/**
	 * Calcula o valor de uma compra de um serviço levando em conta o tipo de cliente e se a data do pagamento é inferior a 10 dias do vencimento.
	 * 
	 * @return o valor total a ser pago
	 */
	public Double calcularValorCompra(Long id) {

		Compra compra = this.getCompras().stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
		if (compra == null) {
			return 0.0;
		}

		double desconto = this.getTipoCliente().getDesconto();

		LocalDate localDate = LocalDate.parse(compra.getDataFim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		if (localDate.isBefore(LocalDate.now().minusDays(10))) {
			desconto -= 0.05;
		}

		return compra.getServico().getPreco() * desconto;

	}

	public void pagar(Long id) {
		Compra compra = this.getCompras().stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
		compra.setPaga(true);
	}

}
