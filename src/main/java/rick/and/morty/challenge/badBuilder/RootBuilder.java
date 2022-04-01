package rick.and.morty.challenge.badBuilder;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import rick.and.morty.challenge.client.RickAndMortyClientRest;
import rick.and.morty.challenge.domain.Location;
import rick.and.morty.challenge.domain.Origin;
import rick.and.morty.challenge.domain.Root;

public class RootBuilder {
	
	private RickAndMortyClientRest rickAndMortyClientRest;

	@Autowired
	public RootBuilder(RickAndMortyClientRest rickAndMortyClientRest) {
		this.rickAndMortyClientRest = rickAndMortyClientRest;
	}

	public Root makeANewRoot(int id) {

		Root newRoot = rickAndMortyClientRest.findById(id);
		newRoot.setEpisode_count(newRoot.getEpisode().size());
		Location location = rickAndMortyClientRest.findByLocation(id);
		
		Origin origin = makeANewOrigin(newRoot, Optional.of(location));
		newRoot.setOrigin(origin);

		return newRoot;
	}

	public Origin makeANewOrigin(Root root, Optional<Location> location) {

		Origin origin = new Origin();

		if (location.isPresent()) {
			origin.setName(root.getOrigin().getName());
			origin.setUrl(root.getOrigin().getUrl());
			origin.setDimension(location.get().getDimension());
			origin.setResidents(location.get().getResidents());
		}

		return origin;
	}

}
