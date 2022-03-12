package br.edu.infnet.dashboardappagendamentocarga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.dashboardappagendamentocarga.client.IVeiculoClient;
import br.edu.infnet.dashboardappagendamentocarga.model.domain.Veiculo;

@Service
public class VeiculoService {
	
	@Autowired
	private IVeiculoClient veiculoClient;
	
	public List<Veiculo> obterLista(){
		return veiculoClient.obterLista();
	}
}
