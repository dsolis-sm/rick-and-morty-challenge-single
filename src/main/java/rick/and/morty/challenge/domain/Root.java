package rick.and.morty.challenge.domain;

import java.util.List;


public class Root {
	
	/** The id. */
	private int id;
	
	/** The name. */
	private String name;
	
	/** The status. */
	private String status;
	
	/** The species. */
	private String species;
	
	/** The type. */
	private String type;
	
	/** The episode count. */
	private int episode_count;
	
	/** The origin. */
	private Origin origin;
	
	/** The episode. */
	private List<String> episode;
	
	public Root() {
		
	}

	public Root(int id, String name, String status, String species, String type, int episode_count, Origin origin,
			List<String> episode) {
		this.id = id;
		this.name = name;
		this.status = status;
		this.species = species;
		this.type = type;
		this.episode_count = episode_count;
		this.origin = origin;
		this.episode = episode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getEpisode_count() {
		return episode_count;
	}

	public void setEpisode_count(int episode_count) {
		this.episode_count = episode_count;
	}

	public Origin getOrigin() {
		return origin;
	}

	public void setOrigin(Origin origin) {
		this.origin = origin;
	}

	public List<String> getEpisode() {
		return episode;
	}

	public void setEpisode(List<String> episode) {
		this.episode = episode;
	}
	
}
