package TheatreService.repository;

import TheatreService.model.AuditoriumLayout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriumLayoutRepository extends JpaRepository<AuditoriumLayout, Integer> {
}
