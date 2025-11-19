package TheatreService.service;

import TheatreService.repository.TheatreRepository;

public class TheatreService {

    private TheatreRepository theatreRepository;

    public TheatreService(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }
}
