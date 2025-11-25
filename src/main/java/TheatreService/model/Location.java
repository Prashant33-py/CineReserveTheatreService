package TheatreService.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    private String street;
    private String area;
    private String city;
    private String state;
    @Column(name = "zipCode", nullable = false)
    private int zipCode;
}
