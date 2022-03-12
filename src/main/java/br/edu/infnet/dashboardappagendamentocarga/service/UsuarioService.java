package br.edu.infnet.dashboardappagendamentocarga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.dashboardappagendamentocarga.client.IUsuarioClient;
import br.edu.infnet.dashboardappagendamentocarga.model.domain.Usuario;

@Service
public class UsuarioService {

	@Autowired
	public IUsuarioClient usuarioClient; 
	
	public List<Usuario> obterLista(){
		return usuarioClient.obterLista();
	}
}