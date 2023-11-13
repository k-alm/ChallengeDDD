package br.com.fiap.challenge.ddd.domain;

public class Bike {

	private String marca;
	private String modelo;
	private String fabricante;
	private String numeroSerie;
	private int anoFabricacao, id;
	
	public Bike(String marca, String modelo, String fabricante, String numeroSerie, int anoFabricacao, int id) {
		if(marca == null || marca.isBlank()) {
			throw new IllegalArgumentException("O campo de marca está vazio");
		}
		
		if(modelo == null || modelo.isBlank()) {
			throw new IllegalArgumentException("O campo de modelo está vazio");
		}
		
		if(fabricante == null || fabricante.isBlank()) {
			throw new IllegalArgumentException("O campo de fabricante  está vazio");
		}
		
		if(numeroSerie == null || numeroSerie.isBlank() || numeroSerie.length() < 10) {
			throw new IllegalArgumentException("Número de série não pode ser vazio e deve conter pelo menos 10 caracteres");
		}
		
		if(anoFabricacao < 2000) {
			throw new IllegalArgumentException("Ano de fabricação inválido");
		}
		
		if(id < 0) {
			throw new IllegalArgumentException("Id não pode ser menor que zero");
		}
		
		this.setId(id);
		this.setAnoFabricacao(anoFabricacao);
		this.setFabricante(fabricante);
		this.setMarca(marca);
		this.setModelo(modelo);
		this.setNumeroSerie(numeroSerie);
	}

	
	@Override
	public String toString() {
		return String.format("Id: %s | Marca: %s | Modelo: %s | Número de série: %s", this.id, this.marca, this.modelo, this.numeroSerie);
	}
	
	//Getters and Setters
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

	public void setNumeroSerie(String numero_serie) {
		this.numeroSerie = numero_serie;
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int ano_fabricacao) {
		this.anoFabricacao = ano_fabricacao;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
}
