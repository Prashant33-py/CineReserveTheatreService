package TheatreService.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "seats")
public class Seat {

    public enum SeatType {
        STANDARD, RECLINER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seat_id")
    private int seatId;

    @Column(name = "seatNumber")
    private String seatNumber;

    @Column(name = "seatType")
    private SeatType seatType;

    @Column(name = "seatXPosition")
    private double seatXPosition;

    @Column(name = "seatYPosition")
    private double seatYPosition;

    @Column(name = "seatWidth")
    private double seatWidth;

    @Column(name = "seatLength")
    private double seatLength;

    @Column(name = "isAvailable")
    private boolean isAvailable;

    public void setSeatDimensions(SeatType seatType) {
        switch (seatType) {
            case RECLINER:
                setSeatWidth(0.75);
                setSeatLength(2.5);
                break;

            case STANDARD:
                setSeatWidth(0.5);
                setSeatLength(0.5);
                break;

            default:
                throw new IllegalArgumentException("Unknown seat type: " + seatType);

        }
    }

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "zone_id", referencedColumnName = "zone_id")
    private Zone zone;
}
