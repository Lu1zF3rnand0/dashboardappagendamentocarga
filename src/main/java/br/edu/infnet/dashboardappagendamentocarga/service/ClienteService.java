package br.edu.infnet.dashboardappagendamentocarga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.dashboardappagendamentocarga.client.IClienteClient;
import br.edu.infnet.dashboardappagendamentocarga.model.domain.Cliente;

@Service
public class ClienteService {

	@Autowired
	private IClienteClient clienteClient;
	
	public List<Cliente> obterLista(){
		return clienteClient.obterLista();
	}
}