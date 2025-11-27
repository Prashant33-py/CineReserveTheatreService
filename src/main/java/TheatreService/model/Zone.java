package TheatreService.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@ToString(exclude = "seats")
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
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.REMOVE
            }
    )
    @JsonManagedReference
    private List<Seat> seats = new ArrayList<>();

}
