package br.edu.infnet.dashboardappagendamentocarga.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboardappagendamentocarga.model.domain.Cliente;

@FeignClient(url = "localhost:8083/api/cliente", name = "clienteClient")
public interface IClienteClient {

	@GetMapping(value = "/listar")
	public List<Cliente> obterLista();

}