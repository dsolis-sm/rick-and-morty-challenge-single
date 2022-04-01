package rick.and.morty.challenge.controller;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import rick.and.morty.challenge.domain.vo.LocationVO;
import rick.and.morty.challenge.service.RickAndMortyLocationService;

@RestController
@RequestMapping("rick-and-morty/v1")
public class RickAndMortyLocationController {
	
	private static final Log LOGGER = LogFactory.getLog(RickAndMortyLocationController.class);
	
	private RickAndMortyLocationService rickAndMortyLocationService;


	@Autowired
	public RickAndMortyLocationController(RickAndMortyLocationService rickAndMortyLocationService) {
		this.rickAndMortyLocationService = rickAndMortyLocationService;
	}
		
	/**
	 * Método que consulta una petición con el id de alguna localización.
	 *
	 * @param id de la localización
	 * @return Retorna la información mediante el objeto Location.
	 */
	@GetMapping("/location/{id}")
	@ApiOperation(value = "findByLocation", notes = "Se encarga de consultar una peticion con el id de alguna localizacion.")
	public Optional<LocationVO> findByLocation(
			@ApiParam(name = "id", value = "id de la localizacion", type = "int", required = true)
			@PathVariable int id) {
		LOGGER.trace("Peticion para obtener informacion de la localización por id");
		return rickAndMortyLocationService.findByLocation(id);
	
	}
	
	

}
