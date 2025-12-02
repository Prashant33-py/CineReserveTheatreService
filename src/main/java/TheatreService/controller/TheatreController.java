package TheatreService.controller;

import TheatreService.dto.TheatreDTO;
import TheatreService.model.Theatre;
import TheatreService.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cine-reserve/theatre")
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    @PostMapping
    public ResponseEntity<String> addTheatre(@RequestBody Theatre theatre) {
        return theatreService.addTheatre(theatre);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TheatreDTO> getTheatreById(@PathVariable("id") int theatreId){
        return theatreService.getTheatreById(theatreId);
    }

}
