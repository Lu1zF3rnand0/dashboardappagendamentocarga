package br.edu.infnet.dashboardappagendamentocarga.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboardappagendamentocarga.model.domain.Usuario;
import br.edu.infnet.dashboardappagendamentocarga.service.AgendamentoService;
import br.edu.infnet.dashboardappagendamentocarga.service.CargaSoltaService;
import br.edu.infnet.dashboardappagendamentocarga.service.ConteinerService;
import br.edu.infnet.dashboardappagendamentocarga.service.LogService;
import br.edu.infnet.dashboardappagendamentocarga.service.UsuarioService;
import br.edu.infnet.dashboardappagendamentocarga.service.VeiculoService;

@Controller
public class DashboardController {
	
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private AgendamentoService agendamentoService;
	
	@Autowired
	private ConteinerService conteinerService;

	@Autowired
	private VeiculoService veiculoService;

	@Autowired
	private CargaSoltaService cargaSoltaService;

	@Autowired
	private LogService logService;

	@GetMapping(value = "/")
	public String index(Model model) {

		//produtos e pedidos por usuário
		List<Usuario> usuarios = usuarioService.obterLista();		
		model.addAttribute("agendamentosPorUsuario", usuarios);		
		model.addAttribute("cargasPorUsuario", usuarios);
		
		//quantidade de pedidos
		model.addAttribute("qtdeAgendamentos", agendamentoService.obterLista().size());
		
//		//valor de vendos dos produtos
//		model.addAttribute("valorVendaBebida", bebidaService.calcularValorVenda());
//		model.addAttribute("valorVendaComida", comidaService.calcularValorVenda());
//		model.addAttribute("valorVendaSobremsa", sobremesaService.calcularValorVenda());

		//recuperar o log
		model.addAttribute("listaLog", logService.obterLista());
		model.addAttribute("qtdeLog", logService.obterQuantidade());
		
		return "index";
	}
}