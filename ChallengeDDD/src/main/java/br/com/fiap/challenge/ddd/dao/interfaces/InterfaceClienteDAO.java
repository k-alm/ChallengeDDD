package br.com.fiap.challenge.ddd.dao.interfaces;

import br.com.fiap.challenge.ddd.domain.Cliente;

public interface InterfaceClienteDAO {
	public void salvar(Cliente cliente);
	public Cliente consultar(int id);
}
