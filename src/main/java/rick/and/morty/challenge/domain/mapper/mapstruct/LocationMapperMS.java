package rick.and.morty.challenge.domain.mapper.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import rick.and.morty.challenge.domain.Location;
import rick.and.morty.challenge.domain.dto.LocationDTO;
import rick.and.morty.challenge.domain.vo.LocationVO;

@Mapper(componentModel = "spring")
public interface LocationMapperMS {
	
	@Mapping(source = "id", target = "id")
	@Mapping(source = "name", target = "name")
	@Mapping(source = "type", target = "type")
	@Mapping(source = "dimension", target = "dimension")
	@Mapping(source = "residents", target = "residents")
	LocationDTO mapLocationDTO(Location location);
	
	@Mapping(source = "id", target = "id")
	@Mapping(source = "name", target = "name")
	@Mapping(source = "type", target = "type")
	@Mapping(source = "dimension", target = "dimension")
	@Mapping(source = "residents", target = "residents")
	LocationVO mapLocationVO(LocationDTO locationDTO);
	
	@Mapping(source = "id", target = "id")
	@Mapping(source = "name", target = "name")
	@Mapping(source = "type", target = "type")
	@Mapping(source = "dimension", target = "dimension")
	@Mapping(source = "residents", target = "residents")
	Location mapLocation (LocationDTO locationDTO);
	
	@Mapping(source = "id", target = "id")
	@Mapping(source = "name", target = "name")
	@Mapping(source = "type", target = "type")
	@Mapping(source = "dimension", target = "dimension")
	@Mapping(source = "residents", target = "residents")
	Location mapVOLocation(LocationVO locationVO);

}
