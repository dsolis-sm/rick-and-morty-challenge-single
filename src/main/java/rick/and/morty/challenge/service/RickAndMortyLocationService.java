package rick.and.morty.challenge.service;

import java.util.Optional;

import rick.and.morty.challenge.domain.vo.LocationVO;

public interface RickAndMortyLocationService {
	
	/**
	 * Método que consulta una petición con el id  de algún localización.
	 *
	 * @param id de la localización
	 * @return Retorna la información mediante el objeto Location.
	 */
	public Optional<LocationVO> findByLocation(int id);

}
