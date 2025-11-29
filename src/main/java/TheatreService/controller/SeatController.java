package TheatreService.controller;

import TheatreService.model.Seat;
import TheatreService.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cine-reserve/theatre/seat")
public class SeatController {

    @Autowired
    private SeatService seatService;

/*    @PostMapping("/seat")
    public ResponseEntity<String> addSeat(@RequestBody Seat seat) {
        return seatService.addSeat(seat);

    }*/

}
