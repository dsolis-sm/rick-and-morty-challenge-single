package rick.and.morty.challenge.goodBuilder;

import rick.and.morty.challenge.domain.Location;
import rick.and.morty.challenge.domain.Origin;
import rick.and.morty.challenge.domain.Root;

public class OriginBuilderGood {
	
	public Origin makeANewOrigin(Root root, Location location) {
		
		Origin origin = new Origin();
		origin.setName(root.getOrigin().getName());
		origin.setUrl(root.getOrigin().getUrl());
		origin.setDimension(location.getDimension());
		origin.setResidents(location.getResidents());
		
		return origin;
		
	}

}
