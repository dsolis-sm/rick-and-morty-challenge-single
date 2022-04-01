package rick.and.morty.challenge.service;

import java.util.Optional;

import rick.and.morty.challenge.domain.vo.RootVO;

public interface RickAndMortyCharacterService {
	
	/**
	 * Método que consulta una petición con el id  de algún personaje de la serie.
	 *
	 * @param id del personaje
	 * @return Retorna la información mediante el objeto Root.
	 */
	public Optional<RootVO> findById(int id);
	
}
