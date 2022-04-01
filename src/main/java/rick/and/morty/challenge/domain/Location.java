package rick.and.morty.challenge.domain;

import java.util.List;


public class Location {
	
	private int id;
	
	private String name;
	
	private String type;
	
	private String dimension;
	
	private List<String> residents;
	
	public Location() {
		
	}
	
	public Location(int id, String name, String type, String dimension, List<String> residents) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.dimension = dimension;
		this.residents = residents;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
