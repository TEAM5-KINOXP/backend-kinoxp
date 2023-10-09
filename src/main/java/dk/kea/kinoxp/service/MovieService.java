package dk.kea.kinoxp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import dk.kea.kinoxp.api_facade.OmdbFacade;
import dk.kea.kinoxp.dto.MovieOmdbResponse;
import dk.kea.kinoxp.entity.Movie;
import dk.kea.kinoxp.repository.MovieRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MovieService {
    MovieRepository movieRepository;

    @Autowired
    OmdbFacade omdbFacade;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie getMovieByImdbId(String imdbId) {
        return movieRepository.findByImdbID(imdbId).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found"));
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
    public void deleteMovie(int id) {
        movieRepository.deleteById(id);
    }
//    public ResponseEntity<Boolean> editMovie(MovieRequest body, int id){
//        Movie movie = movieRepository.findById(id).
//                orElseThrow(()-> new
//                        ResponseStatusException(HttpStatus.NOT_FOUND,"Movie with this id does not exist"));
//        if(!(body.getId()==id)){
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Cannot change movie");
//        }
//        movie.setTitle(body.getTitle());
//        movie.setGenre(body.getGenre());
//        movie.setDescription(body.getDescription());
//        movieRepository.save(movie);
//        return ResponseEntity.ok(true);
//    }
    public Movie addMovie(String imdbId) throws JsonProcessingException {

    MovieOmdbResponse dto = omdbFacade.getMovie(imdbId);

    // Convert the poster image to base64
    String posterBase64 = convertImageToBase64(dto.getPosterImg());

    Movie movie = Movie.builder()
            .title(dto.getTitle())
            .genre(dto.getGenre())
            .description(dto.getDescription())
            .posterImg(posterBase64)  // Store the base64 encoded image
            .imdbID(dto.getImdbID())
            .build();
    try {
        movieRepository.save(movie);
        return movie;
    } catch (DataIntegrityViolationException e) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getRootCause().getMessage());
    } catch (Exception e) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not add movie");
    }
}

    // Helper method to convert an image URL to base64
    private String convertImageToBase64(String imageUrl) {
        RestTemplate restTemplate = new RestTemplate();
        byte[] imageBytes = restTemplate.getForObject(imageUrl, byte[].class);
        if (imageBytes != null) {
            return Base64.encodeBase64String(imageBytes);
        }
        return null;
    }
}

