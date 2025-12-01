package TheatreService.dto;

import TheatreService.model.Theatre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuditoriumDTO {

    private int auditoriumId;
    private String name;
    private int seatingCapacity;
    private TheatreDTO theatre;

}
