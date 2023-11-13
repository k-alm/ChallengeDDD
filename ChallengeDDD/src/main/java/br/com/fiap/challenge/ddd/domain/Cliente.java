package br.com.fiap.challenge.ddd.domain;

public class Cliente {
	private String nome, email, telefone;
	private int id;
	
	public Cliente(String nome, String email, String telefone, int id) {
		if(nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("O campo de nome está vazio");
		}
		
		if(email == null || email.isBlank()) {
			throw new IllegalArgumentException("O campo de email está vazio");
		}
		
		if(!email.contains("@")) {
			throw new IllegalArgumentException("Email inválido");	
		}
		
		if(telefone == null || telefone.isBlank()) {
			throw new IllegalArgumentException("O campo de telefone está vazio");
		}
		
		if(id < 0) {
			throw new IllegalArgumentException("Id não pode ser menor que zero");
		}
		
		this.setId(id);
		this.setNome(nome);
		this.setTelefone(telefone);
		this.setEmail(email);			
		
	}
	
	@Override
	public String toString() {
		return String.format("Nome: %s: email: %s | telefone: %s", this.nome, this.email, this.telefone);
	}
	
	//Getters and Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
