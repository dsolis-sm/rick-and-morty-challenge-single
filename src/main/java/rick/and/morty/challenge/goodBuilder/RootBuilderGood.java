package rick.and.morty.challenge.goodBuilder;

import org.springframework.beans.factory.annotation.Autowired;

import rick.and.morty.challenge.client.RickAndMortyClientRest;
import rick.and.morty.challenge.domain.Root;

public class RootBuilderGood {
	
	private RickAndMortyClientRest rickAndMortyClientRest;

	@Autowired
	public RootBuilderGood(RickAndMortyClientRest rickAndMortyClientRest) {
		this.rickAndMortyClientRest = rickAndMortyClientRest;
	}
	
	public Root makeANewRoot(int id) {

		Root newRoot = rickAndMortyClientRest.findById(id);
		newRoot.setEpisode_count(newRoot.getEpisode().size());
		
		return newRoot;
	}

}
