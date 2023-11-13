package br.com.fiap.challenge.ddd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.challenge.ddd.dao.interfaces.InterfaceVistoriaDAO;
import br.com.fiap.challenge.ddd.domain.Vistoria;

public class VistoriaDAO implements InterfaceVistoriaDAO{

	private Connection conn;
	
	public VistoriaDAO(Connection connection) {
		this.conn = connection;
	}
	
	public void salvar(Vistoria vistoria, int idBike) {
		String sql = "INSERT INTO t_prt_vistoria(st_status, img_bike, dt_vistoria, id_vistoria, id_bike) "
				+ "VALUES(?, EMPTY_BLOB(), TO_DATE(?, 'DD/MM/YYYY'), sq_prt_vistoria.NEXTVAL, ?)";
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, vistoria.getStatus());
			preparedStatement.setString(2, vistoria.getDtVistoria());
			preparedStatement.setInt(3, idBike);

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

	public Vistoria consultar(int id) {
		String sql = "SELECT * FROM t_prt_vistoria WHERE id_vistoria = ?";
		
		PreparedStatement ps;
		ResultSet rs;
		Vistoria vistoria = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String statusRS = rs.getString(1);
				int idVistoriaRS = rs.getInt(3);
				
				vistoria = new Vistoria(statusRS, idVistoriaRS);
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
		
		return vistoria;
	}
	
}
