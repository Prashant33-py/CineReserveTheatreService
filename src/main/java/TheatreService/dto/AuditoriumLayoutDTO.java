package TheatreService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditoriumLayoutDTO {

    private int layoutId;
    private List<ZoneDTO> zones;

}
