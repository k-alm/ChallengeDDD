package br.com.fiap.challenge.ddd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.challenge.ddd.dao.interfaces.InterfaceBikeDAO;
import br.com.fiap.challenge.ddd.domain.Bike;

public class BikeDAO implements InterfaceBikeDAO{

	private Connection conn;
	
	public BikeDAO(Connection connection) {
		this.conn = connection;
	}
	
	public void salvar(Bike bike, int idCliente) {
		String sql = "INSERT INTO t_prt_bike(nm_numero_serie, nm_marca, nm_modelo, nm_fabricante, nr_ano_fabricacao, id_bike, id_cliente)"
				+ " VALUES(?, ?, ?, ?, ?, sq_prt_bike.NEXTVAL, ?)";
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, bike.getNumeroSerie());
			preparedStatement.setString(2, bike.getMarca());
			preparedStatement.setString(3, bike.getModelo());
			preparedStatement.setString(4, bike.getFabricante());
			preparedStatement.setInt(5, bike.getAnoFabricacao());
			preparedStatement.setInt(6, idCliente);

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

	public Bike consultar(int id) {
		String sql = "SELECT * FROM t_prt_bike WHERE id_bike = ?";
		
		PreparedStatement ps;
		ResultSet rs;
		Bike bike = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String numeroSerieRS = rs.getString(1);
				String marcaRS = rs.getString(2);
				String modeloRS = rs.getString(3);
				String fabricanteRS = rs.getString(4);
				int anoFabricacaoRS = rs.getInt(5);
				int idBikeRS = rs.getInt(6);

				bike = new Bike(marcaRS, modeloRS, fabricanteRS, numeroSerieRS, anoFabricacaoRS, idBikeRS);
			}
			rs.close();
			ps.close();
			conn.close();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		
		return bike;
	}

	
}
