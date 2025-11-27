package TheatreService.model;

import TheatreService.repository.SeatRepository;
import TheatreService.repository.ZoneRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Transactional
class ZoneTest {

    @Autowired
    private ZoneRepository zoneRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Test
    public void testZoneCreation() {

        Zone vipZone = Zone.builder()
                .name("VIP")
                .price(300)
                .build();
        Zone reclinerZone = Zone.builder()
                .name("RECLINER")
                .price(300)
                .build();

        Seat seat1 = Seat.builder()
                .seatType(Seat.SeatType.RECLINER)
                .seatNumber("R1")
                .seatXPosition(1)
                .seatYPosition(1)
                .isAvailable(true)
                .zone(reclinerZone)
                .build();
        seat1.setSeatDimensions(seat1.getSeatType());

        Seat seat2 = Seat.builder()
                .seatType(Seat.SeatType.STANDARD)
                .seatNumber("A2")
                .seatXPosition(2)
                .seatYPosition(1)
                .isAvailable(true)
                .zone(vipZone)
                .build();
        seat2.setSeatDimensions(seat2.getSeatType());

        Seat seat3 = Seat.builder()
                .seatType(Seat.SeatType.STANDARD)
                .seatNumber("A3")
                .seatXPosition(3)
                .seatYPosition(1)
                .isAvailable(false)
                .zone(vipZone)
                .build();
        seat3.setSeatDimensions(seat3.getSeatType());

        zoneRepository.save(vipZone);
        zoneRepository.save(reclinerZone);
        seatRepository.saveAll(List.of(seat1, seat2, seat3));

        System.out.println(vipZone);
        System.out.println(seat1);

    }

    @Test
    public void getSeatsByZone() {
        Zone zone = zoneRepository.findByName("RECLINER");
        if (zone != null) {
            List<Seat> seatsInZone = seatRepository.findAllByZone_ZoneId(zone.getZoneId());
            seatsInZone.forEach(System.out::println);
        }
    }

}