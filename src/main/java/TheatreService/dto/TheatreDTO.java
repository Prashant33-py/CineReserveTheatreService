package TheatreService.dto;

import TheatreService.model.Location;
import TheatreService.model.Theatre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TheatreDTO {

    private int theatreId;
    private String name;
    private Location location;
    private List<Theatre.Amenity> amenities;
    private AuditoriumDTO auditorium;

}
