package TheatreService.model;

import TheatreService.repository.SeatRepository;
import TheatreService.repository.ZoneRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ZoneTest {

    @Autowired
    private ZoneRepository zoneRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Test
    public void testZoneCreation() {
        Seat seat1 = Seat.builder()
                .seatType(Seat.SeatType.RECLINER)
                .seatNumber("A1")
                .seatXPosition(1)
                .seatYPosition(1)
                .isAvailable(true)
                .build();
        seat1.setSeatDimensions(seat1.getSeatType());

        Seat seat2 = Seat.builder()
                .seatType(Seat.SeatType.STANDARD)
                .seatNumber("A2")
                .seatXPosition(2)
                .seatYPosition(1)
                .isAvailable(true)
                .build();
        seat2.setSeatDimensions(seat2.getSeatType());

        Seat seat3 = Seat.builder()
                .seatType(Seat.SeatType.STANDARD)
                .seatNumber("A3")
                .seatXPosition(3)
                .seatYPosition(1)
                .isAvailable(false)
                .build();
        seat3.setSeatDimensions(seat3.getSeatType());

        Zone vipZone = Zone.builder()
                .name("VIP")
                .price(300)
                .build();

        vipZone.addSeat(seat1);
        vipZone.addSeat(seat2);
        vipZone.addSeat(seat3);
        zoneRepository.save(vipZone);
//        seatRepository.saveAll(seats);

        System.out.println(vipZone);
        System.out.println(seat1);

    }

}