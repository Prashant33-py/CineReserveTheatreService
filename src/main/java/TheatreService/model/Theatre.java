package TheatreService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@Entity
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private Location location;
    private int totalSeats;
    private int availableSeats;

    @Data
    public static class Location {
        private String address;
        private String city;
        private String state;
        private String zipCode;
    }

    public static class Zone {
        private String zoneName;

    }
}
