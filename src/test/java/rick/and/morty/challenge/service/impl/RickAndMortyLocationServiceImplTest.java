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
import rick.and.morty.challenge.exception.BadRequestException;
import rick.and.morty.challenge.domain.dto.LocationDTO;
import rick.and.morty.challenge.domain.mapper.mapstruct.LocationMapperMS;
import rick.and.morty.challenge.domain.vo.LocationVO;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RickAndMortyLocationServiceImplTest {

	@Mock
	private RickAndMortyClientRest rickAndMortyClientRest;
	
	@Mock
	private LocationMapperMS locationMapperMS;

	@InjectMocks
	private RickAndMortyLocationServiceImpl rickAndMortyLocationService;


	@Test
	public void findByLocationOK() {

		int id = 1;

		LocationVO locationVO = LocationVO.builder()
				.id(1)
				.name("Earth (C-137)")
				.type("Planet")
				.dimension("Dimension C-137")
				.residents(residentsList())
				.build();
		
		LocationDTO locationDTO = LocationDTO.builder()
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

		Optional<LocationVO> response = Optional.of(locationVO);

		Mockito.when(rickAndMortyClientRest.findByLocation(id)).thenReturn(location);
		Mockito.when(locationMapperMS.mapLocationDTO(location)).thenReturn(locationDTO);
		Mockito.when(locationMapperMS.mapLocationVO(locationDTO)).thenReturn(locationVO);
		

		Optional<LocationVO> expected = rickAndMortyLocationService.findByLocation(id);

		Assert.assertEquals(response.get().getId(), expected.get().getId());
		Assert.assertEquals(response.get().getName(), expected.get().getName());
		Assert.assertEquals(response.get().getType(), expected.get().getType());
		Assert.assertEquals(response.get().getDimension(), expected.get().getDimension());
		Assert.assertEquals(response.get().getResidents(), expected.get().getResidents());

	}

	@Test(expected = BadRequestException.class)
	public void findByLocationNOK() {

		int id = -1;

		Mockito.when(rickAndMortyClientRest.findByLocation(id)).thenThrow(FeignException.class);

		rickAndMortyLocationService.findByLocation(id);

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

}
