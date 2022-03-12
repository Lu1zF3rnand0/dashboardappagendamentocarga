package br.edu.infnet.dashboardappagendamentocarga.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboardappagendamentocarga.model.domain.Veiculo;

@FeignClient(url = "localhost:8082/api/carga", name = "veiculoClient")
public interface IVeiculoClient {

	@GetMapping(value = "/veiculo/listar")
	public List<Veiculo> obterLista();
}
