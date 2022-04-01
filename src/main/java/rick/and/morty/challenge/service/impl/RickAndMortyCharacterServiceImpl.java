package rick.and.morty.challenge.service.impl;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import feign.FeignException;
import rick.and.morty.challenge.client.RickAndMortyClientRest;
import rick.and.morty.challenge.domain.Location;
import rick.and.morty.challenge.domain.Origin;
import rick.and.morty.challenge.domain.Root;
import rick.and.morty.challenge.domain.dto.RootDTO;
import rick.and.morty.challenge.domain.mapper.mapstruct.LocationMapperMS;
import rick.and.morty.challenge.domain.mapper.mapstruct.RootMapperMS;
import rick.and.morty.challenge.domain.vo.LocationVO;
import rick.and.morty.challenge.domain.vo.RootVO;
import rick.and.morty.challenge.exception.BadRequestException;
import rick.and.morty.challenge.goodBuilder.OriginBuilderGood;
import rick.and.morty.challenge.goodBuilder.RootBuilderGood;
import rick.and.morty.challenge.service.RickAndMortyCharacterService;
import rick.and.morty.challenge.service.RickAndMortyLocationService;

@Service
public class RickAndMortyCharacterServiceImpl implements RickAndMortyCharacterService {

	private static final Log LOGGER = LogFactory.getLog(RickAndMortyCharacterServiceImpl.class);

	private RickAndMortyClientRest rickAndMortyClientRest;
	
	private RickAndMortyLocationService rickAndMortyLocationService;
	
	private RootMapperMS rootMapperMS;
	
	private LocationMapperMS locationMapperMS;
	
	@Autowired
	public RickAndMortyCharacterServiceImpl(RickAndMortyClientRest rickAndMortyClientRest,
			RickAndMortyLocationService rickAndMortyLocationService, RootMapperMS rootMapperMS, LocationMapperMS locationMapperMS) {
		this.rickAndMortyClientRest = rickAndMortyClientRest;
		this.rickAndMortyLocationService = rickAndMortyLocationService;
		this.rootMapperMS = rootMapperMS;
		this.locationMapperMS = locationMapperMS;
	}

	@Override
	public Optional<RootVO> findById(int id) {
		LOGGER.info("Inicio findById(" + id + ")");
		try {

			RootBuilderGood rootBuilder = new RootBuilderGood(rickAndMortyClientRest);
			
			OriginBuilderGood originBuilderGood = new OriginBuilderGood();
			
			Root root = rootBuilder.makeANewRoot(id);
			String[] idLocation = root.getOrigin().getUrl().split("/");
			
			if(idLocation[0].equals("")) {
				 throw new RuntimeException("Ha ocurrido un error");
			}
			
			String idLocation2 = idLocation[5];
			Optional<LocationVO> locationVO = rickAndMortyLocationService.findByLocation(Integer.parseInt(idLocation2));
			Location location = null;
			if(locationVO.isPresent()) {
				location = locationMapperMS.mapVOLocation(locationVO.get());
			}
			
			Origin origin = originBuilderGood.makeANewOrigin(root, location);
			root.setOrigin(origin);
			
			//RootDTO rootDTO = RootMapper.mapRoot(root);
			RootDTO rootDTO = rootMapperMS.mapRootDTO(root);
			
			
			return Optional.ofNullable(rootMapperMS.mapRootVO(rootDTO));

		} catch (FeignException e) {
			LOGGER.error("Error en findById(" + id + ")");
		    LOGGER.error(e.getMessage(), e.getCause());
		    throw new BadRequestException("Ha ocurrido el siguiente error:" + e.getLocalizedMessage());
		}
	}
	
}
