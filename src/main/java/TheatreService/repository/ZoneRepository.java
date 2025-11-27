package TheatreService.repository;

import TheatreService.model.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Integer> {
    @Query(value = "select * from zones as z where z.name=:zoneName", nativeQuery = true)
    Zone findByName(String zoneName);
}
