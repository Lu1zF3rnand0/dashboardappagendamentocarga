package br.edu.infnet.dashboardappagendamentocarga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.dashboardappagendamentocarga.client.ICargaClient;
import br.edu.infnet.dashboardappagendamentocarga.model.domain.Carga;

@Service
public class CargaService {
	
	@Autowired
	private ICargaClient cargaClient;
	
	public List<Carga> obterLista(){
		return cargaClient.obterLista();
	}
}
