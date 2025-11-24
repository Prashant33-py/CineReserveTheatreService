package TheatreService.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
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
    private String auditoriumId;
    private String name;
    private int seatingCapacity;
}
