package Trabalho1;

public class Usuario{
	private int idUsuario;
	private String nome;
	private String email;
	
	public Usuario() {
		this.idUsuario = -1;
		this.nome = "";
		this.email = "";
	}
	
	public Usuario(int idUsuario, String nome, String email) {
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//Função toString sobrecarregada para mostrar os dados salvos na classe Usuario

	@Override
	public String toString() {
		String user = "Identificador: " + this.idUsuario + System.lineSeparator() + "Nome: " + this.nome
		+ System.lineSeparator() + "Email: " + this.email + System.lineSeparator();
		
		return user;
	}

}
