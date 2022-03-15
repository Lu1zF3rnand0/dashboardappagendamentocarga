package br.edu.infnet.dashboardappagendamentocarga.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboardappagendamentocarga.model.domain.Usuario;
import br.edu.infnet.dashboardappagendamentocarga.service.AgendamentoService;
import br.edu.infnet.dashboardappagendamentocarga.service.LogService;
import br.edu.infnet.dashboardappagendamentocarga.service.UsuarioService;

@Controller
public class DashboardController {
	
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private AgendamentoService agendamentoService;
	
	@Autowired
	private LogService logService;

	@GetMapping(value = "/")
	public String index(Model model) {

		List<Usuario> usuarios = usuarioService.obterLista();		
		model.addAttribute("agendamentosPorUsuario", usuarios);		
		model.addAttribute("cargasPorUsuario", usuarios);
		
		model.addAttribute("qtdeAgendamentos", agendamentoService.obterLista().size());
		
		model.addAttribute("listaLog", logService.obterLista());
		model.addAttribute("qtdeLog", logService.obterQuantidade());
		
		return "index";
	}
}