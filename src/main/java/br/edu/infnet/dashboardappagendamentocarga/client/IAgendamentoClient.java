package br.edu.infnet.dashboardappagendamentocarga.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboardappagendamentocarga.model.domain.Agendamento;

@FeignClient(url = "localhost:8081/api/agendamento", name = "agendamentoClient")
public interface IAgendamentoClient {
	
	@GetMapping(value = "/listar")
	public List<Agendamento> obterLista();
}
