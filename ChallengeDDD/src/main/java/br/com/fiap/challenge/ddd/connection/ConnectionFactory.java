package br.com.fiap.challenge.ddd.connection;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {
	
	public Connection recuperarConexao() {
		try {
            return createDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
    private HikariDataSource createDataSource() {
        HikariConfig config = new HikariConfig();
        
        config.setJdbcUrl("jdbc:oracle:thin:@//oracle.fiap.com.br:1521/ORCL");
        config.setUsername("rm552075");
        config.setPassword("290105");
        config.setMaximumPoolSize(10);

        return new HikariDataSource(config);
    }
}
