package TheatreService.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ZoneTest {

    @Test
    public void testZoneCreation() {
        Seat seat1 = Seat.builder()
                .seatId("1")
                .seatType(Seat.SeatType.STANDARD)
                .seatNumber("A1")
                .seatLength(0.5)
                .seatWidth(0.5)
                .seatXPosition(1)
                .seatYPosition(1)
                .isAvailable(true)
                .build();
        Seat seat2 = Seat.builder()
                .seatId("2")
                .seatType(Seat.SeatType.STANDARD)
                .seatNumber("A2")
                .seatLength(0.5)
                .seatWidth(0.5)
                .seatXPosition(2)
                .seatYPosition(1)
                .isAvailable(true)
                .build();

        Seat seat3 = Seat.builder()
                .seatId("3")
                .seatType(Seat.SeatType.STANDARD)
                .seatNumber("A3")
                .seatLength(0.5)
                .seatWidth(0.5)
                .seatXPosition(3)
                .seatYPosition(1)
                .isAvailable(false)
                .build();

        List<String> seats = List.of(seat1.getSeatId(), seat2.getSeatId(), seat3.getSeatId());

        Zone vipZone = Zone.builder()
                .zoneId("Z01")
                .name("VIP")
                .price(300)
                .seatIds(seats)
                .build();

        System.out.println(vipZone);

    }

}