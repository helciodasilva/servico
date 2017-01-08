package com.helciodasilva.servico.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.helciodasilva.servico.client.model.Cliente;
import com.helciodasilva.servico.client.model.Compra;
import com.helciodasilva.servico.client.model.Empresa;
import com.helciodasilva.servico.client.model.Servico;
import com.helciodasilva.servico.client.service.EmpresaService;

/**
 * Controller de Empresa.
 * 
 * @author Helcio da Silva
 * @since 07/01/2017
 */
@Controller
@RequestMapping("empresa")
public class EmpresaController {

	@Autowired
	private EmpresaService empresaService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView findAll() {
		List<Empresa> empresas = empresaService.findAll();
		ModelAndView mv = new ModelAndView("empresaForm");
		mv.addObject("empresas", empresas);
		return mv;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView findOne(@PathVariable("id") Long id) {
		Empresa empresa = empresaService.findOne(id);
		ModelAndView mv = new ModelAndView("empresaCadastro");
		mv.addObject("empresa", empresa);
		return mv;

	}

	@RequestMapping(value = "/{id}/cliente", method = RequestMethod.POST)
	public ModelAndView addCliente(@PathVariable("id") Long id, Cliente cliente) {
		empresaService.addCliente(id, cliente);
		Empresa empresa = empresaService.findOne(id);
		ModelAndView mv = new ModelAndView("redirect:/empresa");
		mv.addObject("empresa", empresa);
		return mv;
	}

	@RequestMapping(value = "/{id}/servico", method = RequestMethod.POST)
	public ModelAndView addServico(@PathVariable("id") Long id, Servico servico) {
		empresaService.addServico(id, servico);
		ModelAndView mv = new ModelAndView("redirect:/empresa");
		return mv;
	}

	@RequestMapping(value = "/{idEmpresa}/cliente/{idCliente}", method = RequestMethod.GET)
	public ModelAndView findCliente(@PathVariable("idEmpresa") Long idEmpresa,
			@PathVariable("idCliente") Long idCliente) {

		Empresa empresa = empresaService.findOne(idEmpresa);

		Cliente cliente = empresaService.findCliente(idCliente);

		ModelAndView mv = new ModelAndView("clienteCadastro");
		mv.addObject("empresa", empresa);
		mv.addObject("cliente", cliente);
		mv.addObject("servicos", empresa.getServicos());
		return mv;
	}

	@RequestMapping(value = "/{idEmpresa}/cliente/{idCliente}", method = RequestMethod.POST)
	public ModelAndView adquirirServico(@PathVariable("idEmpresa") Long idEmpresa,
			@PathVariable("idCliente") Long idCliente, Compra compra) {

		empresaService.adquirirServico(idCliente, compra);
		Empresa empresa = empresaService.findOne(idEmpresa);
		Cliente cliente = empresaService.findCliente(idCliente);
		ModelAndView mv = new ModelAndView("clienteCadastro");
		mv.addObject("empresa", empresa);
		mv.addObject("cliente", cliente);
		mv.addObject("servicos", empresa.getServicos());
		return mv;
	}

	@RequestMapping(value = "/{idEmpresa}/cliente/{idCliente}/compra/{idCompra}", params = {
			"operacao=pagamento" }, method = RequestMethod.GET)
	public ModelAndView pagarServico(@PathVariable("idEmpresa") Long idEmpresa,
			@PathVariable("idCliente") Long idCliente, @PathVariable("idCompra") Long idCompra) {

		empresaService.pagarServico(idCliente, idCompra);
		;

		Empresa empresa = empresaService.findOne(idEmpresa);
		Cliente cliente = empresaService.findCliente(idCliente);

		ModelAndView mv = new ModelAndView("clienteCadastro");
		mv.addObject("empresa", empresa);
		mv.addObject("cliente", cliente);
		mv.addObject("servicos", empresa.getServicos());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Empresa empresa) {
		empresaService.salvar(empresa);
		return new ModelAndView("redirect:/empresa");
	}

}
