package br.com.fiap.challenge.ddd.services;

import java.sql.Connection;

import br.com.fiap.challenge.ddd.connection.ConnectionFactory;
import br.com.fiap.challenge.ddd.dao.BikeDAO;
import br.com.fiap.challenge.ddd.domain.Bike;

public class BikeServices {
	private ConnectionFactory connection;

    public BikeServices() {
        this.connection = new ConnectionFactory();
    }
    
    public void cadastrarBike(Bike bike, int idCliente) {
    	Connection conn = connection.recuperarConexao();
    	new BikeDAO(conn).salvar(bike, idCliente);
    }
    
    public Bike consultarBike(int id){
    	Connection conn = connection.recuperarConexao();
    	
    	return new BikeDAO(conn).consultar(id);
    }
}

