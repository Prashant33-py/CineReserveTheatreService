package TheatreService.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditoriumLayout {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String layoutId;
    private List<Zone> zones;





}
