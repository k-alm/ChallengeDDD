package br.com.fiap.challenge.ddd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.challenge.ddd.dao.interfaces.InterfaceClienteDAO;
import br.com.fiap.challenge.ddd.domain.Cliente;

public class ClienteDAO implements InterfaceClienteDAO{

	private Connection conn;
	
	public ClienteDAO(Connection connection) {
		this.conn = connection;
	}
	
	public void salvar(Cliente cliente) {
		String sql = "INSERT INTO t_prt_cliente(id_cliente, nm_nome, nm_email, nm_telefone) VALUES(sq_prt_cliente.NEXTVAL, ?, ?, ?)";
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getEmail());
			preparedStatement.setString(3, cliente.getTelefone());
			
			preparedStatement.execute();
			preparedStatement.close();
			conn.close();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}
	
	public Cliente consultar(int id){
		String sql = "SELECT * FROM t_prt_cliente WHERE id_cliente = ?";
		
		PreparedStatement ps;
		ResultSet rs;
		Cliente cliente = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String nomeRS = rs.getString(1);
				int idClienteRS = rs.getInt(2);
				String emailRS = rs.getString(3);
				String telefoneRS = rs.getString(4);
				
				cliente = new Cliente(nomeRS, emailRS, telefoneRS, idClienteRS);
			}
			rs.close();
			ps.close();
			conn.close();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		
		return cliente;
	}
}
