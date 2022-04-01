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
public class RootVO {
	
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
	private OriginVO origin;
	
	/** The episode. */
	private List<String> episode;

}
