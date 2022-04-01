package rick.and.morty.challenge.domain;

import java.util.List;

public class Origin {
	
	/** The name. */
	private String name;
	
	/** The url. */
	private String url;
	
	/** The dimension. */
	private String dimension;
	
	/** The residents. */
	private List<String> residents;
	
	public Origin() {
		
	}

	public Origin(String name, String url, String dimension, List<String> residents) {
		this.name = name;
		this.url = url;
		this.dimension = dimension;
		this.residents = residents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public List<String> getResidents() {
		return residents;
	}

	public void setResidents(List<String> residents) {
		this.residents = residents;
	}
	
}
