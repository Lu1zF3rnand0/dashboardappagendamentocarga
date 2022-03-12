package br.edu.infnet.dashboardappagendamentocarga.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboardappagendamentocarga.model.domain.Carga;

@FeignClient(url = "localhost:8082/api/carga", name = "cargaClient")
public interface ICargaClient {

	@GetMapping(value = "/listar")
	public List<Carga> obterLista();
}
