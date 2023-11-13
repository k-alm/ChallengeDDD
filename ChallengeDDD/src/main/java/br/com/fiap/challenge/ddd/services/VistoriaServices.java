package br.com.fiap.challenge.ddd.services;

import java.sql.Connection;

import br.com.fiap.challenge.ddd.connection.ConnectionFactory;
import br.com.fiap.challenge.ddd.dao.VistoriaDAO;
import br.com.fiap.challenge.ddd.domain.Vistoria;

public class VistoriaServices {
	private ConnectionFactory connection;

    public VistoriaServices() {
        this.connection = new ConnectionFactory();
    }
    
    public void cadastrarVistoria(Vistoria vistoria, int idBike) {
    	Connection conn = connection.recuperarConexao();
    	new VistoriaDAO(conn).salvar(vistoria, idBike);
    }
    
    public Vistoria consultarVistoria(int id){
    	Connection conn = connection.recuperarConexao();
    	
    	return new VistoriaDAO(conn).consultar(id);
    }
}
