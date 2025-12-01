package TheatreService.controller;

import TheatreService.dto.AuditoriumDTO;
import TheatreService.model.Auditorium;
import TheatreService.service.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cine-reserve/theatre/auditorium")
public class AuditoriumController {

    @Autowired
    private AuditoriumService auditoriumService;

    @PostMapping
    public ResponseEntity<String> addAuditorium(@RequestBody Auditorium auditorium, @RequestParam Integer theatreId) {
        return auditoriumService.addAuditorium(auditorium, theatreId);
    }

    @GetMapping("{id}")
    public ResponseEntity<AuditoriumDTO> getAuditoriumById(@PathVariable int id) {
        return auditoriumService.getAuditoriumById(id);
    }

}
