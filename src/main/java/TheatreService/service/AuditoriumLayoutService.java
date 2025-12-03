package TheatreService.service;

import TheatreService.repository.AuditoriumLayoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditoriumLayoutService {

    @Autowired
    private AuditoriumLayoutRepository auditoriumLayoutRepository;


}
