package br.com.fiap.challenge.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.challenge.ddd.domain.Vistoria;
import br.com.fiap.challenge.ddd.services.VistoriaServices;
import br.com.fiap.challenge.dto.VistoriaDTO;
import br.com.fiap.challenge.dto.TransformarEmDTO;

@Path("/vistoria")
public class VistoriaResource {

	VistoriaServices vistoriaServices = new VistoriaServices();
	TransformarEmDTO dto = new TransformarEmDTO();
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarVistoria(@PathParam("id") int id){
		
		Vistoria vistoria = vistoriaServices.consultarVistoria(id);
		VistoriaDTO vistoriaDTO = dto.transformarVistoriaEmDto(vistoria);
		
		if (vistoriaDTO == null) {
			return Response.noContent().build();
		} else {
			return Response.ok(vistoriaDTO).build();
		}
	}			
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrarVistoria(Vistoria vistoria, @Context int idBike, @Context UriInfo uriInfo) {	
		vistoriaServices.cadastrarVistoria(vistoria, idBike);
		
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(vistoria.getId()));
		
		return Response.created(builder.build()).build();
	}

}
