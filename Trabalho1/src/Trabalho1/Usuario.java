package Trabalho1;

public class Usuario {
	private String idUsuario;
	private String nome;
	private String email;
	
	public Usuario() {
		this.idUsuario = "";
		this.nome = "";
		this.email = "";
	}
	
	public Usuario(String idUsuario, String nome, String email) {
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
	}
	
	public String getIdUsuario() {
		return idUsuario;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		String user = "Identificador: " + this.idUsuario + System.lineSeparator() + "Nome: " + this.nome
		+ System.lineSeparator() + "Email: " + this.email + System.lineSeparator();
		
		return user;
	}

}
