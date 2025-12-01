package TheatreService.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString(exclude = "auditoriums")
@Entity
@Table(name = "theatres")
public class Theatre {

    public enum Amenity {
        PARKING, FOOD_COURT, RESTROOMS, WHEELCHAIR_ACCESSIBLE, FIRE_EXITS, LOUNGE_AREA
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "theatre_id")
    private int id;
    private String name;

    @Embedded
    private Location location;
    private List<Amenity> amenities;

    @OneToMany(
            mappedBy = "theatre",
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.REMOVE
            },
            fetch = FetchType.LAZY
    )
    private List<Auditorium> auditoriums;
}
