package rick.and.morty.challenge.service.impl;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import feign.FeignException;
import rick.and.morty.challenge.client.RickAndMortyClientRest;
import rick.and.morty.challenge.domain.Location;
import rick.and.morty.challenge.exception.BadRequestException;
import rick.and.morty.challenge.domain.dto.LocationDTO;
import rick.and.morty.challenge.domain.mapper.mapstruct.LocationMapperMS;
import rick.and.morty.challenge.domain.vo.LocationVO;
import rick.and.morty.challenge.service.RickAndMortyLocationService;

@Service
public class RickAndMortyLocationServiceImpl implements RickAndMortyLocationService {
	
	private static final Log LOGGER = LogFactory.getLog(RickAndMortyLocationServiceImpl.class);

	private RickAndMortyClientRest rickAndMortyClientRest;
	
	private LocationMapperMS locationMapperMS;

	@Autowired
	public RickAndMortyLocationServiceImpl(RickAndMortyClientRest rickAndMortyClientRest,
			LocationMapperMS locationMapperMS) {
		this.rickAndMortyClientRest = rickAndMortyClientRest;
		this.locationMapperMS = locationMapperMS;
	}

	@Override
	public Optional<LocationVO> findByLocation(int id) {
		LOGGER.info("Inicio findByLocation(" + id + ")");
		try {
			
			Location location = rickAndMortyClientRest.findByLocation(id);
			LocationDTO locationDTO = locationMapperMS.mapLocationDTO(location);
			
			return Optional.ofNullable(locationMapperMS.mapLocationVO(locationDTO));
		} catch (FeignException e) {
			LOGGER.error("Error en findByLocation(" + id + ")");
			LOGGER.error(e.getMessage(), e.getCause());
			throw new BadRequestException("Ha ocurrido el siguiente error:" + e.getLocalizedMessage());
		}
	}

}
