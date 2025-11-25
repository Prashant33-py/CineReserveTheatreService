package TheatreService.model;

import lombok.*;

import java.util.List;

@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Zone {

    private String zoneId;
    private String name;
    private double price;


    private List<String> seatIds;

}
