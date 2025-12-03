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
public class ZoneDTO {

    private int zoneId;
    private String name;
    private double price;
    private List<SeatDTO> seats;

}
