package rick.and.morty.challenge.domain.mapper;

import rick.and.morty.challenge.domain.Root;
import rick.and.morty.challenge.domain.dto.OriginDTO;
import rick.and.morty.challenge.domain.dto.RootDTO;

public class RootMapper {
	
	public static RootDTO mapRoot(Root root) {
		
		RootDTO rootDTO = new RootDTO();
		rootDTO.setId(root.getId());
		rootDTO.setName(root.getName());
		rootDTO.setStatus(root.getStatus());
		rootDTO.setSpecies(root.getSpecies());
		rootDTO.setType(root.getType());
		rootDTO.setEpisode_count(root.getEpisode_count());
		
		OriginDTO originDTO = new OriginDTO();
		originDTO.setName(root.getOrigin().getName());
		originDTO.setUrl(root.getOrigin().getUrl());
		originDTO.setDimension(root.getOrigin().getDimension());
		originDTO.setResidents(root.getOrigin().getResidents());
		
		rootDTO.setOrigin(originDTO);
		rootDTO.setEpisode(root.getEpisode());
		
		return rootDTO;
	}
	

}
