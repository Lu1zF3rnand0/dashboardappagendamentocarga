package br.edu.infnet.dashboardappagendamentocarga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.dashboardappagendamentocarga.client.ICargaSoltaClient;
import br.edu.infnet.dashboardappagendamentocarga.model.domain.CargaSolta;

@Service
public class CargaSoltaService {
	
	@Autowired
	private ICargaSoltaClient cargaSoltaClient;
	
	public List<CargaSolta> obterLista(){
		return cargaSoltaClient.obterLista();
	}
}
