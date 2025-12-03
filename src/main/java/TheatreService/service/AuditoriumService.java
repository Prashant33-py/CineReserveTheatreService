package TheatreService.service;

import TheatreService.dto.AuditoriumDTO;
import TheatreService.model.Auditorium;
import TheatreService.model.Theatre;
import TheatreService.repository.AuditoriumRepository;
import TheatreService.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditoriumService {

    @Autowired
    private AuditoriumRepository auditoriumRepository;

    @Autowired
    private TheatreRepository theatreRepository;

    /**
     * Add a new auditorium and set the theatre
     * @param auditorium Auditorium object to be added
     * @param theatreId ID of the theatre to which the auditorium belongs
     * @return ResponseEntity with status and message
     */
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

    /**
     * Get auditorium by ID
     * @param id ID of the auditorium
     * @return ResponseEntity containing {@link AuditoriumDTO}
     */
    public ResponseEntity<AuditoriumDTO> getAuditoriumById(Integer id) {
        Auditorium auditorium = auditoriumRepository.findById(id).orElse(null);
        AuditoriumDTO auditoriumDTO = null;
        if (auditorium != null) {
            auditoriumDTO = AuditoriumDTO.builder()
                    .auditoriumId(auditorium.getAuditoriumId())
                    .name(auditorium.getName())
                    .seatingCapacity(auditorium.getSeatingCapacity())
                    .build();
        }
        return new ResponseEntity<>(auditoriumDTO, HttpStatus.OK);
    }

    /**
     * Get all auditoriums by theatre ID
     * @param theatreId ID of the theatre
     * @return List of {@link AuditoriumDTO}
     */
    public List<AuditoriumDTO> getAuditoriumsByTheatreId(Integer theatreId) {
        List<Auditorium> auditoriums = auditoriumRepository.findByTheatre_Id(theatreId);
        return auditoriums.stream().map(auditorium -> AuditoriumDTO.builder()
                .auditoriumId(auditorium.getAuditoriumId())
                .name(auditorium.getName())
                .seatingCapacity(auditorium.getSeatingCapacity())
                .build()).toList();
    }

}
