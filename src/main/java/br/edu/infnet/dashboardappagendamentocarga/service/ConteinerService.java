package br.edu.infnet.dashboardappagendamentocarga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.dashboardappagendamentocarga.client.IConteinerClient;
import br.edu.infnet.dashboardappagendamentocarga.model.domain.Conteiner;

@Service
public class ConteinerService {
	
	@Autowired
	private IConteinerClient conteinerClient;
	
	public List<Conteiner> obterLista(){
		return conteinerClient.obterLista();
	}
}
