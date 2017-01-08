package com.helciodasilva.servico.api.test.unit;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;

import org.junit.Test;

import com.helciodasilva.servico.api.enums.TipoCliente;
import com.helciodasilva.servico.api.model.Cliente;
import com.helciodasilva.servico.api.model.Compra;
import com.helciodasilva.servico.api.model.builder.CompraServicoBuilder;

/**
 * Classe de teste para validar o calculo dos descontos dos Serviços que são contratados pelos Clientes.
 * 
 * @author Helcio da Silva
 * @since 07/01/2017
 */
public class DescontoTest {
	
	@Test
	public void shouldDiscountForSilverClient() throws Exception {
		Compra compra = new CompraServicoBuilder()
												  .withId(1L)
												  .withPreco(100)
												  .withTipoCliente(TipoCliente.PRATA)
												  .withDataVencimento(LocalDate.now())
												  .build();
		
		
		Cliente cliente = new Cliente("Cliente", Arrays.asList(compra), TipoCliente.PRATA);
		Double valor = cliente.calcularValorCompra(compra.getId());
		assertEquals(95D, valor, 0.01);
	}
	
	@Test
	public void shouldDiscountForGoldClient() throws Exception {
		Compra compra = new CompraServicoBuilder()
				  								  .withId(1L)
				  								  .withPreco(100)
				  								  .withTipoCliente(TipoCliente.OURO)
				  								  .withDataVencimento(LocalDate.now())
				  								  .build();
		
		Cliente cliente = new Cliente("Cliente", Arrays.asList(compra), TipoCliente.OURO);
		Double valor = cliente.calcularValorCompra(compra.getId());
		assertEquals(90D, valor, 0.01);
	}

	@Test
	public void shouldDiscountForSilverClientAndDate() throws Exception {
		
		Compra compra = new CompraServicoBuilder()
				  								  .withId(1L)
				  								  .withPreco(100)
				  								  .withTipoCliente(TipoCliente.PRATA)
				  								  .withDataVencimento(LocalDate.now().minusMonths(1))
				  								  .build();
		
		Cliente cliente = new Cliente("Cliente", Arrays.asList(compra), TipoCliente.PRATA);
		Double valor = cliente.calcularValorCompra(compra.getId());
		assertEquals(90D, valor, 0.01);
	}
	
	@Test
	public void shouldDiscountForGoldClientAndDate() throws Exception {
		Compra compra = new CompraServicoBuilder()
												  .withId(1L)
												  .withPreco(100)
												  .withTipoCliente(TipoCliente.OURO)
												  .withDataVencimento(LocalDate.now().minusMonths(1))
												  .build();
		
		Cliente cliente = new Cliente("Cliente", Arrays.asList(compra), TipoCliente.OURO);
		Double valor = cliente.calcularValorCompra(compra.getId());
		assertEquals(85D, valor, 0.01);
	}

}