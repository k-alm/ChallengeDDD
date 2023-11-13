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

import br.com.fiap.challenge.ddd.domain.Bike;
import br.com.fiap.challenge.ddd.services.BikeServices;
import br.com.fiap.challenge.dto.BikeDTO;
import br.com.fiap.challenge.dto.TransformarEmDTO;

@Path("/bike")
public class BikeResource {

	BikeServices bikeServices = new BikeServices();
	TransformarEmDTO dto = new TransformarEmDTO();
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarBike(@PathParam("id") int id){
		
		Bike bike = bikeServices.consultarBike(id);
		BikeDTO bikeDTO = dto.transformarBikeEmDto(bike);
		
		if (bikeDTO == null) {
			return Response.noContent().build();
		} else {
			return Response.ok(bikeDTO).build();
		}
	}			
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrarBike(Bike bike, @Context int idCliente, @Context UriInfo uriInfo) {	
		bikeServices.cadastrarBike(bike, idCliente);
		
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(bike.getId()));
		
		return Response.created(builder.build()).build();
	}

}
