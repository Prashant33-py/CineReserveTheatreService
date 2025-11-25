package TheatreService.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class Seat {

    public enum SeatType {
        STANDARD, RECLINER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String seatId;
    private String seatNumber;
    private SeatType seatType;
    private double seatXPosition;
    private double seatYPosition;
    private double seatWidth;
    private double seatLength;
    private boolean isAvailable;

}
