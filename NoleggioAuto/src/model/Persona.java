package model;

public class Persona {

	private String nome;
	private String cognome;
	private String CF;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCF() {
		return CF;
	}
	public void setCF(String cF) {
		CF = cF;
	}
	
	
	/*
	 */
	public Persona(String nome, String cognome) {
		super();
		this.nome = nome;
		this.cognome = cognome;
	}
	
	public Persona(){
		
		
		
	}
	public Persona(String nome, String cognome, String codiceFiscale) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.CF = codiceFiscale;
	}
	
	
	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", cognome=" + cognome + ", CF=" + CF
				+ "]";
	}
	
	
}
