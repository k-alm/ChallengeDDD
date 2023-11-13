package br.com.fiap.challenge.ddd.dao.interfaces;

import br.com.fiap.challenge.ddd.domain.Vistoria;

public interface InterfaceVistoriaDAO {
	public void salvar(Vistoria vistoria, int idBike);
	public Vistoria consultar(int id);
}
