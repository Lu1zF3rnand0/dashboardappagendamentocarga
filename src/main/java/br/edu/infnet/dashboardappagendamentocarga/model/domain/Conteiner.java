package br.edu.infnet.dashboardappagendamentocarga.model.domain;

public class Conteiner extends Carga {

	private String numero;
	private int tamanho;
	private String status;

	@Override
	public String retornaNavio() {
		return "O navio do conteiner "+this.numero+" é o "+super.getNavio()+ "!";
	}

	public Conteiner(String navio, String documento, String porto)  {
		super(navio, documento, porto);
	}

//	public Conteiner(String navio, String documento, String porto, String numero, int tamanho, String status) {
//		this.numero = numero;
//		this.tamanho = tamanho;
//		this.status = status;
//	}
	
//	public Conteiner(String numero, int tamanho, String status) {
//		this.numero = numero;
//		this.tamanho = tamanho;
//		this.status = status;
//	}
	

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(";");
		sb.append(this.numero);
		sb.append(";");
		sb.append(this.tamanho);
		sb.append(";");
		sb.append(this.status);
		return super.toString()+sb.toString();
	}

	public Conteiner() {
		// TODO Auto-generated constructor stub
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho)  {
				
		this.tamanho = tamanho;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
