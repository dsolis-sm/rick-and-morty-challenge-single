package rick.and.morty.challenge.domain.mapper.mapstruct;

import org.mapstruct.Mapper;

import rick.and.morty.challenge.domain.Root;
import rick.and.morty.challenge.domain.dto.RootDTO;
import rick.and.morty.challenge.domain.vo.RootVO;

@Mapper(componentModel = "spring")
public interface RootMapperMS {
	
	RootDTO mapRootDTO(Root root);
	
	RootVO mapRootVO(RootDTO rootDTO);

}
