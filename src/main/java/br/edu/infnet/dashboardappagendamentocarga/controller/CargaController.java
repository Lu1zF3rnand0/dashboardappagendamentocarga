package br.edu.infnet.dashboardappagendamentocarga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.dashboardappagendamentocarga.service.CargaService;

@Controller
public class CargaController {
	
	@Autowired
	private CargaService cargaService;

	@RequestMapping(value = "/cargas", method = RequestMethod.GET )
	public String obterLista(Model model) {
		
		model.addAttribute("listagem", cargaService.obterLista());		

		return "lista/cargas";
	}
}
