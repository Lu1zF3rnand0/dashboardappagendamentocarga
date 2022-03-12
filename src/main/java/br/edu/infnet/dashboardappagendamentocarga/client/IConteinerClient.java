package br.edu.infnet.dashboardappagendamentocarga.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboardappagendamentocarga.model.domain.Conteiner;

@FeignClient(url = "localhost:8082/api/carga", name = "conteinerClient")
public interface IConteinerClient {

	@GetMapping(value = "/conteiner/listar")
	public List<Conteiner> obterLista();
}
