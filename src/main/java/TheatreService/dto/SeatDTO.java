package TheatreService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatDTO {

    private int seatId;
    private String seatNumber;
    private String seatType;
    private double seatXPosition;
    private double seatYPosition;
    private double seatWidth;
    private double seatLength;
    private boolean isAvailable;

}
