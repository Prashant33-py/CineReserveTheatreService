package TheatreService.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"auditoriumLayout", "theatre"})
@Entity
@Table(name = "auditoriums")
public class Auditorium {

    @Id
    @SequenceGenerator(
            sequenceName = "auditorium_sequence",
            name = "auditorium_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "auditorium_sequence",
            strategy = GenerationType.SEQUENCE
    )
    @Column(name = "auditorium_id")
    private String auditoriumId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "seatingCapacity", nullable = false)
    private int seatingCapacity;

    @ManyToOne(
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "layout_id", referencedColumnName = "layout_id")
    private AuditoriumLayout auditoriumLayout;

    @ManyToOne(
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "theatre_id", referencedColumnName = "theatre_id")
    private Theatre theatre;
}
