package TheatreService.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "zones")
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "zone_id")
    private int zoneId;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @OneToMany(
            mappedBy = "zone",
            cascade = CascadeType.ALL
    )
    private List<Seat> seats = new ArrayList<>();

    public void addSeat(Seat seat) {
        if (seat == null) return;
        seat.setZone(this);
        this.seats.add(seat);
    }

    public void removeSeat(Seat seat) {
        if (seat == null) return;
        seat.setZone(null);
        this.seats.remove(seat);
    }

}
