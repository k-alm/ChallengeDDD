package br.com.fiap.challenge.ddd.services;

import java.sql.Connection;

import br.com.fiap.challenge.ddd.connection.ConnectionFactory;
import br.com.fiap.challenge.ddd.dao.ClienteDAO;
import br.com.fiap.challenge.ddd.domain.Cliente;

public class ClienteServices {
	private ConnectionFactory connection;

    public ClienteServices() {
        this.connection = new ConnectionFactory();
    }
    
    public void cadastrarCliente(Cliente cliente) {
    	Connection conn = connection.recuperarConexao();
    	new ClienteDAO(conn).salvar(cliente);
    }
    
    public Cliente consultarCliente(int id){
    	Connection conn = connection.recuperarConexao();
    		
    	return new ClienteDAO(conn).consultar(id);
    }
}
