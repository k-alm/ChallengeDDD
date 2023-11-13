package br.com.fiap.challenge.dto;

import br.com.fiap.challenge.ddd.domain.Bike;
import br.com.fiap.challenge.ddd.domain.Cliente;
import br.com.fiap.challenge.ddd.domain.Vistoria;

public class TransformarEmDTO {
	
	public ClienteDTO transformarClienteEmDto(Cliente cliente) {
    	ClienteDTO clienteDTO = new ClienteDTO();
    	clienteDTO.setId(cliente.getId());
    	clienteDTO.setNome(cliente.getNome());
    	clienteDTO.setEmail(cliente.getEmail());
    	clienteDTO.setTelefone(cliente.getTelefone());
    	
    	return clienteDTO;
    }
	
	public BikeDTO transformarBikeEmDto(Bike bike) {
    	BikeDTO bikeDTO = new BikeDTO();
    	bikeDTO.setId(bike.getId());
    	bikeDTO.setMarca(bike.getMarca());
    	bikeDTO.setModelo(bike.getModelo());
    	bikeDTO.setNumeroSerie(bike.getNumeroSerie());
    	bikeDTO.setAnoFabricacao(bike.getAnoFabricacao());
    	bikeDTO.setFabricante(bike.getFabricante());
    	
    	return bikeDTO;
    }
	
	public VistoriaDTO transformarVistoriaEmDto(Vistoria vistoria) {
    	VistoriaDTO vistoriaDto = new VistoriaDTO();
    	vistoriaDto.setDtVistoria(vistoria.getDtVistoria());
    	vistoriaDto.setId(vistoria.getId());
    	vistoriaDto.setStatus(vistoria.getStatus());
    	
    	return vistoriaDto;
    }
}
