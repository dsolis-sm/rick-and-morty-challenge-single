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
import rick.and.morty.challenge.domain.Root;
import rick.and.morty.challenge.domain.vo.RootVO;
import rick.and.morty.challenge.service.RickAndMortyBadService;
import rick.and.morty.challenge.service.RickAndMortyCharacterService;

@RestController
@RequestMapping("rick-and-morty/v1")
public class RickAndMortyCharacterController {
	
	private static final Log LOGGER = LogFactory.getLog(RickAndMortyCharacterController.class);
	
	private RickAndMortyBadService rickAndMortyBadService;
	
	private RickAndMortyCharacterService rickAndMortyGoodService;

	@Autowired
	public RickAndMortyCharacterController(RickAndMortyBadService rickAndMortyBadService, RickAndMortyCharacterService rickAndMortyGoodService) {
		this.rickAndMortyBadService = rickAndMortyBadService;
		this.rickAndMortyGoodService = rickAndMortyGoodService;
	}
	
	/**
	 * Método que consulta una petición con el id de algún personaje de la serie.
	 *
	 * @param id del personaje
	 * @return Retorna la información mediante el objeto Root.
	 */
	@GetMapping("/character/{id}")
	@ApiOperation(value = "findById", notes = "Se encarga de consultar una peticion con el id  de algun personaje de la serie")
	public Optional<Root> findById(
			@ApiParam(name = "id", value = "id del personaje", type = "int", required = true)
			@PathVariable int id) {
		LOGGER.trace("Peticion para obtener información del personaje por id");
		return rickAndMortyBadService.findById(id);
	
	}
	
	/**
	 * Método que consulta una petición con el id de algún personaje de la serie.
	 *
	 * @param id del personaje
	 * @return Retorna la información mediante el objeto Root.
	 */
	@GetMapping("/good/character/{id}")
	@ApiOperation(value = "findById", notes = "Se encarga de consultar una peticion con el id  de algun personaje de la serie")
	public Optional<RootVO> findByIdGood(
			@ApiParam(name = "id", value = "id del personaje", type = "int", required = true)
			@PathVariable int id) {
		LOGGER.trace("Peticion para obtener información del personaje por id");
		return rickAndMortyGoodService.findById(id);
	
	}
	
}
