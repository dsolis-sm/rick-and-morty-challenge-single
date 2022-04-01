package rick.and.morty.challenge.service.impl;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import feign.FeignException;
import rick.and.morty.challenge.badBuilder.RootBuilder;
import rick.and.morty.challenge.client.RickAndMortyClientRest;
import rick.and.morty.challenge.domain.Location;
import rick.and.morty.challenge.domain.Root;
import rick.and.morty.challenge.exception.BadRequestException;
import rick.and.morty.challenge.service.RickAndMortyBadService;

@Service
@Primary
public class RickAndMortyBadServiceImpl implements RickAndMortyBadService {

	private static final Log LOGGER = LogFactory.getLog(RickAndMortyBadServiceImpl.class);

	private RickAndMortyClientRest rickAndMortyClientRest;

	@Autowired
	public RickAndMortyBadServiceImpl(RickAndMortyClientRest rickAndMortyClientRest) {
		this.rickAndMortyClientRest = rickAndMortyClientRest;
	}

	@Override
	public Optional<Root> findById(int id) {
		LOGGER.info("Inicio findById(" + id + ")");
		try {

			RootBuilder rootBuilder = new RootBuilder(rickAndMortyClientRest);
			
			return Optional.ofNullable(rootBuilder.makeANewRoot(id));

		} catch (FeignException e) {
			LOGGER.error("Error en findById(" + id + ")");
		    LOGGER.error(e.getMessage(), e.getCause());
		    throw new BadRequestException("Ha ocurrido el siguiente error:" + e.getLocalizedMessage());
		}
	}

	@Override
	public Optional<Location> findByLocation(int id) {
		LOGGER.info("Inicio findByLocation(" + id + ")");
		try {
			return Optional.ofNullable(rickAndMortyClientRest.findByLocation(id));
		} catch (FeignException e) {
			LOGGER.error("Error en findByLocation(" + id + ")");
			LOGGER.error(e.getMessage(), e.getCause());
			throw new BadRequestException("Ha ocurrido el siguiente error:" + e.getLocalizedMessage());
		}
	}

}
