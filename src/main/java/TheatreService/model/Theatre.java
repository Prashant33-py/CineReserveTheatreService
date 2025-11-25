package TheatreService.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@Entity
public class Theatre {

    enum Amenity {
        PARKING, FOOD_COURT, RESTROOMS, WHEELCHAIR_ACCESSIBLE, FIRE_EXITS, LOUNGE_AREA
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @Embedded
    private Location location;
    private List<Amenity> amenities;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "auditorium_ids", referencedColumnName = "auditoriumId")
    private List<Integer> auditoriumIds;
}
