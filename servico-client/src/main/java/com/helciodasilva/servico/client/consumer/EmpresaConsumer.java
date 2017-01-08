package com.helciodasilva.servico.client.consumer;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.helciodasilva.servico.client.model.Cliente;
import com.helciodasilva.servico.client.model.Compra;
import com.helciodasilva.servico.client.model.Empresa;
import com.helciodasilva.servico.client.model.Servico;

/**
 * Consumir do recurso Empresa.
 * 
 * @author Helcio da Silva
 * @since 07/01/2017
 */
@FeignClient(url = "http://api:8080", value = "empresa")
public interface EmpresaConsumer {

	@RequestMapping(value = "empresa" ,method = RequestMethod.GET)
	public List<Empresa> findAll();

	@RequestMapping(value = "empresa/{id}", method = RequestMethod.GET)
	public Empresa findOne(@PathVariable("id") Long id);

	@RequestMapping(value = "empresa/{id}/cliente", method = RequestMethod.POST)
	public void addCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente);

	@RequestMapping(value = "empresa/servico/{id}", method = RequestMethod.GET)
	public Servico findServico(@PathVariable("id") Long id);
	
	@RequestMapping(value = "empresa/{id}/servico", method = RequestMethod.POST)
	public void addServico(@PathVariable("id") Long id, @RequestBody Servico servico);

	@RequestMapping(value = "empresa/cliente/{id}", method = RequestMethod.GET)
	public Cliente findCliente(@PathVariable("id") Long idCliente);

	@RequestMapping(value = "empresa/cliente/{id}/compra", method = RequestMethod.POST)
	public void adquirirServico(@PathVariable("id") Long id,
								@RequestBody Compra compra);

	@RequestMapping(value = "empresa/cliente/{idCliente}/compra/{idCompra}?operacao=pagamento",
					method = RequestMethod.GET)
	public void pagarServico(@PathVariable("idCliente") Long idCliente, 
							 @PathVariable("idCompra") Long idCompra);

	@RequestMapping(value = "empresa", method = RequestMethod.POST)
	public void salvar(@RequestBody Empresa empresa);

}
