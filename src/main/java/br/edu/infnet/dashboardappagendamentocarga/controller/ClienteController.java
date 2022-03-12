package br.edu.infnet.dashboardappagendamentocarga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.dashboardappagendamentocarga.service.ClienteService;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	


	@RequestMapping(value = "/clientes", method = RequestMethod.GET )
	public String obterLista(Model model) {

		
		model.addAttribute("listagem", clienteService.obterLista());
		
		return "lista/clientes";
	}
	
}