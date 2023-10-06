package dk.kea.kinoxp.api_facade;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import dk.kea.kinoxp.dto.MovieOmdbResponse;
@Service
public class OmdbFacade {
    RestTemplate restTemplate;

    public OmdbFacade() {
        this.restTemplate = new RestTemplate();
    }
    @Value("${app.omdb-key}")
    String API_KEY;

    String OMDB_URL = "http://www.omdbapi.com";

    public MovieOmdbResponse getMovie(String imdbId) {
        String url = OMDB_URL + "/?apikey=" + API_KEY + "&plot=full" + "&i=";
        MovieOmdbResponse movieDTO = restTemplate.getForObject(url + imdbId, MovieOmdbResponse.class);
        return movieDTO;
    }
}
