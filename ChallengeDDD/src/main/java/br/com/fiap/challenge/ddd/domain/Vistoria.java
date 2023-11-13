package br.com.fiap.challenge.ddd.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Vistoria {
	private String status;
	private LocalDateTime dataAtual = LocalDateTime.now();
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private String dtVistoria = dataAtual.format(formatter);
	private int id;
	
	public Vistoria(String status, int id) {
		if(status == null || status.isBlank()) {
			throw new IllegalArgumentException("Status não pode ser vazio");
		}
		
		if(id < 0) {
			throw new IllegalArgumentException("Id não pode ser menor que zero");
		}
		
		this.setId(id);
		this.setStatus(status);
	}
	
	@Override
	public String toString() {
		return String.format("Id: %s | Status: %s | Data: %s", this.id, this.status, this.dtVistoria);
	}
	
	//Getters and Setters
	public int getId() {
		return id;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDtVistoria() {
		return dtVistoria;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
