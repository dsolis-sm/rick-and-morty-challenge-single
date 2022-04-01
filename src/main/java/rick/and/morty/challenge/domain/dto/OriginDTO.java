package rick.and.morty.challenge.domain.dto;

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
public class OriginDTO {
	
	/** The name. */
	private String name;
	
	/** The url. */
	private String url;
	
	/** The dimension. */
	private String dimension;
	
	/** The residents. */
	private List<String> residents;

}
