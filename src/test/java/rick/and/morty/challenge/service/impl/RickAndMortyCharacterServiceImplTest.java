package rick.and.morty.challenge.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import feign.FeignException;
import rick.and.morty.challenge.client.RickAndMortyClientRest;
import rick.and.morty.challenge.domain.Location;
import rick.and.morty.challenge.domain.Origin;
import rick.and.morty.challenge.domain.Root;
import rick.and.morty.challenge.domain.dto.OriginDTO;
import rick.and.morty.challenge.domain.dto.RootDTO;
import rick.and.morty.challenge.domain.mapper.mapstruct.LocationMapperMS;
import rick.and.morty.challenge.domain.mapper.mapstruct.RootMapperMS;
import rick.and.morty.challenge.domain.vo.LocationVO;
import rick.and.morty.challenge.domain.vo.OriginVO;
import rick.and.morty.challenge.domain.vo.RootVO;
import rick.and.morty.challenge.exception.BadRequestException;
import rick.and.morty.challenge.service.RickAndMortyLocationService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RickAndMortyCharacterServiceImplTest {

	@Mock
	private RickAndMortyClientRest rickAndMortyClientRest;
	
	@Mock
	private RickAndMortyLocationService rickAndMortyLocationService;
	
	@Mock
	private LocationMapperMS locationMapperMS;
	
	@Mock
	private RootMapperMS rootMapperMS;

	@InjectMocks
	private RickAndMortyCharacterServiceImpl rickAndMortyCharacterService;

	@Test
	public void findByIdOK() {

		int id = 1;
		
		LocationVO locationVO = LocationVO.builder()
				.id(1)
				.name("Earth (C-137)")
				.type("Planet")
				.dimension("Dimension C-137")
				.residents(residentsList())
				.build();
		
		Location location = new Location();
		location.setId(1);
		location.setName("Earth (C-137)");
		location.setType("Planet");
		location.setDimension("Dimension C-137");
		location.setResidents(residentsList());
		
		Origin origin = new Origin();
		origin.setName("Earth (C-137)");
		origin.setUrl("https://rickandmortyapi.com/api/location/1");
		origin.setDimension("Dimension C-137");
		origin.setResidents(residentsList());
		
		OriginDTO originDTO = OriginDTO.builder()
				.name("Earth (C-137)")
				.url("https://rickandmortyapi.com/api/location/1")
				.dimension("Dimension C-137")
				.residents(residentsList())
				.build();
		
		OriginVO originVO = OriginVO.builder()
				.name("Earth (C-137)")
				.url("https://rickandmortyapi.com/api/location/1")
				.dimension("Dimension C-137")
				.residents(residentsList())
				.build();

		Root root = new Root();
		root.setId(1);
		root.setName("Rick Sanchez");
		root.setStatus("Alive");
		root.setSpecies("Human");
		root.setType("");
		root.setEpisode_count(51);
		root.setOrigin(origin);
		root.setEpisode(episodeList());
		
		RootDTO rootDTO = RootDTO.builder()
				.id(1)
				.name("Rick Sanchez")
				.status("Alive")
				.species("Human")
				.type("")
				.episode_count(51)
				.origin(originDTO)
				.episode(episodeList())
				.build();
		
		RootVO rootVO = RootVO.builder()
				.id(1)
				.name("Rick Sanchez")
				.status("Alive")
				.species("Human")
				.type("")
				.episode_count(51)
				.origin(originVO)
				.episode(episodeList())
				.build();
		
		Optional<RootVO> response = Optional.of(rootVO);
		Optional<LocationVO> responseLocation = Optional.of(locationVO);
		
		Mockito.when(rickAndMortyClientRest.findById(id)).thenReturn(root);
		Mockito.when(rickAndMortyLocationService.findByLocation(id)).thenReturn(responseLocation);
		Mockito.when(locationMapperMS.mapVOLocation(locationVO)).thenReturn(location);
		//Mockito.when(locationMapperMS.mapLocationDTO(location)).thenReturn(locationDTO);
		Mockito.when(rootMapperMS.mapRootDTO(root)).thenReturn(rootDTO);
		Mockito.when(rootMapperMS.mapRootVO(rootDTO)).thenReturn(rootVO);
		
		Optional<RootVO> expected = rickAndMortyCharacterService.findById(id);
		
		Assert.assertEquals(response.get().getId(), expected.get().getId());
		Assert.assertEquals(response.get().getName(), expected.get().getName());
		Assert.assertEquals(response.get().getStatus(), expected.get().getStatus());
		Assert.assertEquals(response.get().getSpecies(), expected.get().getSpecies());
		Assert.assertEquals(response.get().getType(), expected.get().getType());
		Assert.assertEquals(response.get().getEpisode_count(), expected.get().getEpisode_count());
		Assert.assertEquals(response.get().getOrigin(), expected.get().getOrigin());
		Assert.assertEquals(response.get().getEpisode(), expected.get().getEpisode());

	}
	
	@Test(expected = BadRequestException.class)
	public void findByIdNOK() {

		int id = -1;

		Mockito.when(rickAndMortyClientRest.findById(id)).thenThrow(FeignException.class);

		rickAndMortyCharacterService.findById(id);
	}
	
	private List<String> residentsList() {

		List<String> residentList = Arrays.asList("https://rickandmortyapi.com/api/character/38",
				"https://rickandmortyapi.com/api/character/45", "https://rickandmortyapi.com/api/character/71",
				"https://rickandmortyapi.com/api/character/82", "https://rickandmortyapi.com/api/character/83",
				"https://rickandmortyapi.com/api/character/92", "https://rickandmortyapi.com/api/character/112",
				"https://rickandmortyapi.com/api/character/114", "https://rickandmortyapi.com/api/character/116",
				"https://rickandmortyapi.com/api/character/117", "https://rickandmortyapi.com/api/character/120",
				"https://rickandmortyapi.com/api/character/127", "https://rickandmortyapi.com/api/character/155",
				"https://rickandmortyapi.com/api/character/169", "https://rickandmortyapi.com/api/character/175",
				"https://rickandmortyapi.com/api/character/179", "https://rickandmortyapi.com/api/character/186",
				"https://rickandmortyapi.com/api/character/201", "https://rickandmortyapi.com/api/character/216",
				"https://rickandmortyapi.com/api/character/239", "https://rickandmortyapi.com/api/character/271",
				"https://rickandmortyapi.com/api/character/302", "https://rickandmortyapi.com/api/character/303",
				"https://rickandmortyapi.com/api/character/338", "https://rickandmortyapi.com/api/character/343",
				"https://rickandmortyapi.com/api/character/356", "https://rickandmortyapi.com/api/character/394");

		return residentList;
	}

	private List<String> episodeList() {

		List<String> episodeList = Arrays.asList("https://rickandmortyapi.com/api/episode/1",
				"https://rickandmortyapi.com/api/episode/2", "https://rickandmortyapi.com/api/episode/3",
				"https://rickandmortyapi.com/api/episode/4", "https://rickandmortyapi.com/api/episode/5",
				"https://rickandmortyapi.com/api/episode/6", "https://rickandmortyapi.com/api/episode/7",
				"https://rickandmortyapi.com/api/episode/8", "https://rickandmortyapi.com/api/episode/9",
				"https://rickandmortyapi.com/api/episode/10", "https://rickandmortyapi.com/api/episode/11",
				"https://rickandmortyapi.com/api/episode/12", "https://rickandmortyapi.com/api/episode/13",
				"https://rickandmortyapi.com/api/episode/14", "https://rickandmortyapi.com/api/episode/15",
				"https://rickandmortyapi.com/api/episode/16", "https://rickandmortyapi.com/api/episode/17",
				"https://rickandmortyapi.com/api/episode/18", "https://rickandmortyapi.com/api/episode/19",
				"https://rickandmortyapi.com/api/episode/20", "https://rickandmortyapi.com/api/episode/21",
				"https://rickandmortyapi.com/api/episode/22", "https://rickandmortyapi.com/api/episode/23",
				"https://rickandmortyapi.com/api/episode/24", "https://rickandmortyapi.com/api/episode/25",
				"https://rickandmortyapi.com/api/episode/26", "https://rickandmortyapi.com/api/episode/27",
				"https://rickandmortyapi.com/api/episode/28", "https://rickandmortyapi.com/api/episode/29",
				"https://rickandmortyapi.com/api/episode/30", "https://rickandmortyapi.com/api/episode/31",
				"https://rickandmortyapi.com/api/episode/32", "https://rickandmortyapi.com/api/episode/33",
				"https://rickandmortyapi.com/api/episode/34", "https://rickandmortyapi.com/api/episode/35",
				"https://rickandmortyapi.com/api/episode/36", "https://rickandmortyapi.com/api/episode/37",
				"https://rickandmortyapi.com/api/episode/38", "https://rickandmortyapi.com/api/episode/39",
				"https://rickandmortyapi.com/api/episode/40", "https://rickandmortyapi.com/api/episode/41",
				"https://rickandmortyapi.com/api/episode/42", "https://rickandmortyapi.com/api/episode/43",
				"https://rickandmortyapi.com/api/episode/44", "https://rickandmortyapi.com/api/episode/45",
				"https://rickandmortyapi.com/api/episode/46", "https://rickandmortyapi.com/api/episode/47",
				"https://rickandmortyapi.com/api/episode/48", "https://rickandmortyapi.com/api/episode/49",
				"https://rickandmortyapi.com/api/episode/50", "https://rickandmortyapi.com/api/episode/51");

		return episodeList;
	}

}
