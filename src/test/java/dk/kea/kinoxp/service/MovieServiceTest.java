package dk.kea.kinoxp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import dk.kea.kinoxp.api_facade.OmdbFacade;
import dk.kea.kinoxp.dto.MovieOmdbResponse;
import dk.kea.kinoxp.entity.Movie;
import dk.kea.kinoxp.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

    @InjectMocks
    MovieService movieService;
    @Mock
    MovieRepository movieRepository;
    @Mock
    RestTemplate restTemplate;
    @Mock
    OmdbFacade omdbFacade;
    @Test
    void testGetMovieByImdbId() {
        String imdbId = "tt15398776";
        Movie movie = new Movie();
        movie.setImdbID(imdbId);

        when(movieRepository.findByImdbID(imdbId)).thenReturn(Optional.of(movie));

        Movie result = movieService.getMovieByImdbId(imdbId);

        assertEquals(imdbId, result.getImdbID());

    }

    @Test
    void testGetAllMovies() {
        Movie movie = new Movie();
        Movie movie2 = new Movie();
        Movie movie3 = new Movie();

        when(movieRepository.findAll()).thenReturn(Arrays.asList(movie, movie2, movie3));
        List<Movie> movies = movieService.getAllMovies();
        verify(movieRepository, times(1)).findAll();

        assertEquals(3, movieService.getAllMovies().size());

    }

    @Test
    void testDeleteMovie() {

        int id = 69;
        Movie movie = new Movie();
        movie.setId(id);

        movieRepository.deleteById(id);
        verify(movieRepository, times(1)).deleteById(id);

        assertFalse(movieRepository.findById(id).isPresent());
    }

//    @Test
//    void testAddMovie() throws JsonProcessingException {
//        // Arrange
//        String imdbId = "tt1234567";
//        MovieOmdbResponse dto = new MovieOmdbResponse();
//        dto.setTitle("Movie Title");
//        dto.setGenre("Action");
//        dto.setDescription("Description");
//        dto.setImdbID(imdbId);
//        OmdbFacade test = new OmdbFacade();
//        // Mock the behavior of omdbFacade to return the DTO
//        when(test.getMovie(imdbId)).thenReturn(dto);
//
//        // Create a movie object without using a toMovie method
//        Movie movie = new Movie();
//        movie.setTitle(dto.getTitle());
//        movie.setGenre(dto.getGenre());
//        movie.setDescription(dto.getDescription());
//        movie.setImdbID(dto.getImdbID());
//        movie.setPosterImg("https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png");
//
//        // Mock the behavior of movieRepository.save to return the saved movie
//        when(movieRepository.save(any(Movie.class))).thenReturn(movie);
//
//        // Act
//        Movie addedMovie = movieService.addMovie(imdbId);
//
//        // Assert
//        assertNotNull(addedMovie);
//        assertEquals("Movie Title", addedMovie.getTitle());
//        assertEquals("Action", addedMovie.getGenre());
//        assertEquals("Description", addedMovie.getDescription());
//        assertEquals(imdbId, addedMovie.getImdbID());
//    }
}