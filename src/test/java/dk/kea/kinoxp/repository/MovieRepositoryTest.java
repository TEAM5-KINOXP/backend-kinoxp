package dk.kea.kinoxp.repository;

import dk.kea.kinoxp.api_facade.OmdbFacade;
import dk.kea.kinoxp.dto.MovieOmdbResponse;
import dk.kea.kinoxp.entity.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DataJpaTest
class MovieRepositoryTest {

    @Autowired
    MovieRepository movieRepository; // repo to test

    @MockBean
    OmdbFacade omdbFacade; //Mock
    @MockBean
    private MovieOmdbResponse omdbResponse; //Mock

    @Test
    void findByImdbID() {
        // Create a sample Movie
        Movie movie = new Movie();
        movie.setTitle("Sample Movie");
        movie.setGenre("Action");
        movie.setDescription("A sample movie description");
        movie.setPosterImg("sample_base64_encoded_image");
        movie.setImdbID("sample_imdb_id");

        movieRepository.save(movie);

        // Mockito Mock the behavior of the omdbFacade.getMovie method
        when(omdbFacade.getMovie("sample_imdb_id")).thenReturn(omdbResponse);

        // Call the repository method you want to test
        Movie foundMovie = movieRepository.findByImdbID("sample_imdb_id").get();

        // Assert that the retrieved movie matches the one you saved
        assertEquals(movie.getTitle(), foundMovie.getTitle());
        assertEquals(movie.getGenre(), foundMovie.getGenre());
        assertEquals(movie.getDescription(), foundMovie.getDescription());
        assertEquals(movie.getPosterImg(), foundMovie.getPosterImg());
        assertEquals(movie.getImdbID(), foundMovie.getImdbID());
    }
}