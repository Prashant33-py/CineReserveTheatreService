package TheatreService.service;

import TheatreService.dto.AuditoriumDTO;
import TheatreService.dto.TheatreDTO;
import TheatreService.model.Auditorium;
import TheatreService.model.Theatre;
import TheatreService.repository.AuditoriumRepository;
import TheatreService.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuditoriumService {

    @Autowired
    private AuditoriumRepository auditoriumRepository;

    @Autowired
    private TheatreRepository theatreRepository;

    public ResponseEntity<String> addAuditorium(Auditorium auditorium, Integer theatreId) {
        if (theatreRepository.existsById(theatreId)) {
            auditorium.setTheatre(theatreRepository.findById(theatreId).get());
            try {
                auditoriumRepository.save(auditorium);
                return new ResponseEntity<>("Auditorium added successfully", HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>("Failed to add auditorium: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>("Theatre not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<AuditoriumDTO> getAuditoriumById(Integer id) {
        Auditorium auditorium = auditoriumRepository.findById(id).orElse(null);
        AuditoriumDTO auditoriumDTO = null;
        if (auditorium != null) {

            Theatre theatre = auditorium.getTheatre();
            auditoriumDTO = AuditoriumDTO.builder()
                    .auditoriumId(auditorium.getAuditoriumId())
                    .name(auditorium.getName())
                    .seatingCapacity(auditorium.getSeatingCapacity())
                    .theatre(TheatreDTO.builder()
                            .theatreId(theatre.getId())
                            .location(theatre.getLocation())
                            .name(theatre.getName())
                            .amenities(theatre.getAmenities())
                            .build())
                    .build();
        }
        return new ResponseEntity<>(auditoriumDTO, HttpStatus.OK);
    }

}
