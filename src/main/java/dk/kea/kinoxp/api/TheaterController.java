package dk.kea.kinoxp.api;

import dk.kea.kinoxp.service.TheaterService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@CrossOrigin
@RequestMapping("/api/theaters")
public class TheaterController {
    TheaterService theaterService;

    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }
}
