package TheatreService.service;

import TheatreService.model.Theatre;
import TheatreService.repository.TheatreRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TheatreService {

    private final TheatreRepository theatreRepository;

    public TheatreService(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }

    /**
     * This service method adds a new theatre to the database.
     * @param theatre Theatre object to be added
     * @return ResponseEntity with success or error message
     */
    public ResponseEntity<String> addTheatre(Theatre theatre) {
        try {
            theatreRepository.save(theatre);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Theatre added successfully", HttpStatus.OK);
    }

    /**
     * This service method fetches a theatre by its ID.
     * @param id Theatre ID
     * @return ResponseEntity containing the Theatre object or NOT_FOUND status
     */
    public ResponseEntity<Theatre> getTheatreById(Integer id) {
        Theatre theatre = theatreRepository.findById(id).orElse(null);
        if (theatre == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(theatre, HttpStatus.OK);
    }

}
