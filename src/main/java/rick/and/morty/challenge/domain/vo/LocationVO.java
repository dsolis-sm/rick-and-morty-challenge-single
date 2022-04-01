package rick.and.morty.challenge.domain.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocationVO {
	
	private int id;
	
	private String name;
	
	private String type;
	
	private String dimension;
	
	private List<String> residents;

}
