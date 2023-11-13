package br.com.fiap.challenge.resource;

import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.challenge.ddd.domain.Cliente;
import br.com.fiap.challenge.ddd.services.ClienteServices;
import br.com.fiap.challenge.dto.ClienteDTO;
import br.com.fiap.challenge.dto.TransformarEmDTO;


@Path("/cliente")
public class ClienteResource {
	
	ClienteServices clienteServices = new ClienteServices();
	TransformarEmDTO dto = new TransformarEmDTO();
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarCliente(@PathParam("id") int id){
		Cliente cliente = clienteServices.consultarCliente(id);
		ClienteDTO clienteDTO = dto.transformarClienteEmDto(cliente);
		
		if (clienteDTO == null) {
			return Response.noContent().build();
		} else {
			return Response.ok(clienteDTO).build();
		}
	}			
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrarCliente(Cliente cliente, @Context UriInfo uriInfo) {	
		clienteServices.cadastrarCliente(cliente);
		
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(cliente.getId()));
		
		return Response.created(builder.build()).build();
	}
}
