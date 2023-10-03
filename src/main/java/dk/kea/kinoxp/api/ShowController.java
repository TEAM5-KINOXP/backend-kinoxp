package dk.kea.kinoxp.api;

import dk.kea.kinoxp.service.ShowService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/shows")
public class ShowController {
    ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }
}
