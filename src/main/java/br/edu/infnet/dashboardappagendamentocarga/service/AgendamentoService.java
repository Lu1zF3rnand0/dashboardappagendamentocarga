package br.edu.infnet.dashboardappagendamentocarga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.dashboardappagendamentocarga.client.IAgendamentoClient;
import br.edu.infnet.dashboardappagendamentocarga.model.domain.Agendamento;

@Service
public class AgendamentoService {
	
	@Autowired
	private IAgendamentoClient agendamentoClient;

	public List<Agendamento> obterLista(){
		return agendamentoClient.obterLista();
	}
}
