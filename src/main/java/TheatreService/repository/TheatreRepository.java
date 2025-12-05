package TheatreService.repository;

import TheatreService.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer> {
    List<Theatre> findByLocationZipCode(Integer zipCode);
}
