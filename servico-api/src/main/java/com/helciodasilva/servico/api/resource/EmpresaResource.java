package com.helciodasilva.servico.api.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.helciodasilva.servico.api.model.Cliente;
import com.helciodasilva.servico.api.model.Compra;
import com.helciodasilva.servico.api.model.Empresa;
import com.helciodasilva.servico.api.model.Servico;
import com.helciodasilva.servico.api.service.ClienteService;
import com.helciodasilva.servico.api.service.CompraService;
import com.helciodasilva.servico.api.service.EmpresaService;
import com.helciodasilva.servico.api.service.ServicoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Recurso Empresa.
 * 
 * @author Helcio da Silva
 * @since 07/01/2017
 */
@RestController
@RequestMapping("empresa")
@Api(tags = "Empresa")
public class EmpresaResource {

	public static final String REGEX_MAPPER = "(/empresa.*)";

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private EmpresaService empresaService;

	@Autowired
	private ServicoService servicoService;

	@Autowired
	private CompraService compraService;

	@ApiOperation(
			value = "", 
			httpMethod = "GET", 
			notes = "Retorna todas as empresas cadastradas.", 
			response = ResponseEntity.class
	)
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Empresa>> findAll() {
		List<Empresa> empresas = empresaService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(empresas);
	}

	@ApiOperation(
			value = "", 
			httpMethod = "GET", 
			notes = "Retorna uma empresa a partir de um id.", 
			response = ResponseEntity.class
	)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Empresa> findOne(@PathVariable Long id) {
		Empresa empresa = empresaService.findOne(id);
		return ResponseEntity.status(HttpStatus.OK).body(empresa);

	}

	@ApiOperation(
			value = "", 
			httpMethod = "POST", 
			notes = "Persiste um cliente.", 
			response = ResponseEntity.class
	)
	@RequestMapping(value = "/{id}/cliente", method = RequestMethod.POST)
	public ResponseEntity<?> addCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
		Empresa empresa = empresaService.findOne(id);

		if (empresa == null) {
			return ResponseEntity.notFound().build();
		}
		cliente.setId(null);
		clienteService.save(cliente);
		empresa.getClientes().add(cliente);
		empresaService.save(empresa);
		return ResponseEntity.ok().build();
	}

	@ApiOperation(
			value = "", 
			httpMethod = "GET", 
			notes = "Retorna todos os serviços que uma empresa possui.", 
			response = ResponseEntity.class
	)
	@RequestMapping(value = "{id}/servico", method = RequestMethod.GET)
	public ResponseEntity<List<Servico>> findAllServico(@PathVariable("id") Long id) {
		Empresa empresa = empresaService.findOne(id);
		if (empresa == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(empresa.getServicos());
	}

	@ApiOperation(
			value = "", 
			httpMethod = "GET", 
			notes = "Retorna um seviço a partir de um id.", 
			response = ResponseEntity.class
	)
	@RequestMapping(value = "/servico/{id}", method = RequestMethod.GET)
	public ResponseEntity<Servico> findServico(@PathVariable("id") Long id) {
		Servico servico = servicoService.findOne(id);
		return ResponseEntity.status(HttpStatus.OK).body(servico);
	}

	@ApiOperation(
			value = "", 
			httpMethod = "POST", 
			notes = "Persiste um novo serviço.", 
			response = ResponseEntity.class
	)
	@RequestMapping(value = "/{id}/servico", method = RequestMethod.POST)
	public ResponseEntity<?> addServico(@PathVariable("id") Long id, @RequestBody Servico servico) {
		Empresa empresa = empresaService.findOne(id);
		if (empresa == null) {
			return ResponseEntity.notFound().build();
		}
		servico.setId(null);
		servicoService.save(servico);
		empresa.getServicos().add(servico);
		empresaService.save(empresa);
		return ResponseEntity.ok().build();
	}

	@ApiOperation(
			value = "", 
			httpMethod = "GET", 
			notes = "Retorna um cliente a partir de um id.", 
			response = ResponseEntity.class
	)
	@RequestMapping(value = "/cliente/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> findCliente(@PathVariable("id") Long id) {
		Cliente cliente = clienteService.findOne(id);
		return ResponseEntity.status(HttpStatus.OK).body(cliente);
	}

	@ApiOperation(
			value = "", 
			httpMethod = "POST", 
			notes = "Faz a compra de um serviço.", 
			response = ResponseEntity.class
	)
	@RequestMapping(value = "/cliente/{id}/compra", method = RequestMethod.POST)
	public ResponseEntity<?> adquirirServico(@PathVariable("id") Long id, @RequestBody Compra compra) {
		Cliente cliente = clienteService.findOne(id);

		if (cliente == null) {
			return ResponseEntity.notFound().build();
		}
		compraService.save(compra);
		cliente.getCompras().add(compra);
		clienteService.save(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		return ResponseEntity.created(uri).build();

	}

	@ApiOperation(
			value = "", 
			httpMethod = "GET", 
			notes = "Faz o pagamento de uma compra.", 
			response = ResponseEntity.class
	)
	@RequestMapping(value = "/cliente/{idCliente}/compra/{idCompra}", params = {
			"operacao=pagamento" }, method = RequestMethod.GET)
	public ResponseEntity<?> pagarServico(@PathVariable("idCliente") Long idCliente,
										  @PathVariable("idCompra") Long idCompra) {
		
		Cliente cliente = clienteService.findOne(idCliente);
		Compra compra = compraService.findOne(idCompra);

		if (cliente == null || compra == null) {
			return ResponseEntity.notFound().build();
		}

		cliente.pagar(compra.getId());
		clienteService.save(cliente);
		return ResponseEntity.ok().build();
	}

	@ApiOperation(
			value = "", 
			httpMethod = "POST", 
			notes = "Persiste uma empresa", 
			response = ResponseEntity.class
	)
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody Empresa empresa) {
		empresa.setId(null);
		empresaService.save(empresa);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(empresa.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

}
