package br.edu.infnet.dashboardappagendamentocarga.model.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@JsonTypeInfo( 		
		use = JsonTypeInfo.Id.NAME, 		
		include = JsonTypeInfo.As.PROPERTY, 		
		property = "tipo")
@JsonSubTypes({ 	
	@JsonSubTypes.Type(value = Conteiner.class, name = "Conteiner"), 	
	@JsonSubTypes.Type(value = CargaSolta.class, name = "CargaSolta"), 
	@JsonSubTypes.Type(value = Veiculo.class, name = "Veiculo") 
})
public abstract class Carga {
	

	private Integer id;
	private String navio;
	private String documento;
	private String porto;
	

	private List<Agendamento> agendamentos;
	private Usuario usuario;


	public Carga(String navio, String documento, String porto)  {
		this();
		this.navio = navio;
		this.documento = documento;
		this.porto = porto;

	}

	public Carga() {
		//TODO
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.id);
		sb.append(";");
		sb.append(this.navio);
		sb.append(";");
		sb.append(this.documento);
		sb.append(";");
		sb.append(this.porto);
		return sb.toString();
	}

	public abstract String retornaNavio();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNavio() {
		return navio;
	}

	public void setNavio(String navio) {
		this.navio = navio;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getPorto() {
		return porto;
	}

	public void setPorto(String porto) {
		this.porto = porto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}

	

}
