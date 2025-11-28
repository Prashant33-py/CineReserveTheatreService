package TheatreService.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Data
@ToString(exclude = "zones")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "auditorium_layout")
public class AuditoriumLayout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "layout_id")
    private int layoutId;

    @ManyToMany(
            cascade = {
                    CascadeType.MERGE
            },
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "layout_zones",
            joinColumns = @JoinColumn(
                    name = "layout_id",
                    referencedColumnName = "layout_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "zone_id",
                    referencedColumnName = "zone_id"
            )
    )
    private List<Zone> zones;

    public void addZones(Zone zone) {
        if (zones == null) {
            zones = new java.util.ArrayList<>();
        }
        zones.add(zone);
    }

}
