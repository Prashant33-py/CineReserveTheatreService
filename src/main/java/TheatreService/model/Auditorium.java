package TheatreService.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
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
    @Column(name = "auditoriumId")
    private String auditoriumId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "seatingCapacity", nullable = false)
    private int seatingCapacity;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn()
    private AuditoriumLayout auditoriumLayout;
}
