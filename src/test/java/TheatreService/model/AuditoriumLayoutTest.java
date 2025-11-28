package TheatreService.model;

import TheatreService.repository.AuditoriumLayoutRepository;
import TheatreService.repository.ZoneRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class AuditoriumLayoutTest {

    @Autowired
    private ZoneRepository zoneRepository;

    @Autowired
    private AuditoriumLayoutRepository auditoriumLayoutRepository;

    @Test
    public void testAddZonesToAuditoriumLayout() {

        Zone vipZone = zoneRepository.findByName("VIP");
        Zone reclinerZone = zoneRepository.findByName("RECLINER");

        AuditoriumLayout layout = AuditoriumLayout.builder().build();
        layout.addZones(vipZone);
        layout.addZones(reclinerZone);

        auditoriumLayoutRepository.save(layout);

        System.out.println(layout);

    }

    @Test
    public void testGetZonesFromAuditoriumLayout() {
        AuditoriumLayout layout = auditoriumLayoutRepository.findById(4).orElseThrow();
        for (Zone zone : layout.getZones()) {
            System.out.println(zone);
        }
    }

}