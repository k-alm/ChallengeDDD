package br.com.fiap.challenge.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BikeDTO {

	private String marca;
	private String modelo;
	private String fabricante;
	private String numeroSerie;
	private int anoFabricacao, id;
	
	@Override
	public String toString() {
		return String.format("Id: %s | Marca: %s | Modelo: %s | Número de série: %s", this.id, this.marca, this.modelo, this.numeroSerie);
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getNumeroSerie() {
		return numeroSerie;
	}
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	public int getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
