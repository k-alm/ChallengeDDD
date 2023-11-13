package br.com.fiap.challenge.ddd.dao.interfaces;

import br.com.fiap.challenge.ddd.domain.Bike;

public interface InterfaceBikeDAO {
	public void salvar(Bike bike, int idCliente);
	public Bike consultar(int id);
}
