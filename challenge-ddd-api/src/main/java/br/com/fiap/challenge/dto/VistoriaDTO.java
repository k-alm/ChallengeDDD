package br.com.fiap.challenge.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VistoriaDTO {

	private String status;
	private LocalDateTime dataAtual = LocalDateTime.now();
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private String dtVistoria = dataAtual.format(formatter);
	private int id;
	
	@Override
	public String toString() {
		return String.format("Id: %s | Status: %s | Data: %s", this.id, this.status, this.dtVistoria);
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getDataAtual() {
		return dataAtual;
	}

	public void setDataAtual(LocalDateTime dataAtual) {
		this.dataAtual = dataAtual;
	}

	public DateTimeFormatter getFormatter() {
		return formatter;
	}

	public void setFormatter(DateTimeFormatter formatter) {
		this.formatter = formatter;
	}

	public String getDtVistoria() {
		return dtVistoria;
	}

	public void setDtVistoria(String dtVistoria) {
		this.dtVistoria = dtVistoria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
