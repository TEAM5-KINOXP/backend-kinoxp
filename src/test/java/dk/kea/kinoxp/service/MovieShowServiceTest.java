package dk.kea.kinoxp.service;

import dk.kea.kinoxp.dto.MovieShowResponse;
import dk.kea.kinoxp.entity.Movie;
import dk.kea.kinoxp.entity.MovieShow;
import dk.kea.kinoxp.entity.Theater;
import dk.kea.kinoxp.repository.MovieRepository;
import dk.kea.kinoxp.repository.MovieShowRepository;
import dk.kea.kinoxp.repository.TheaterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MovieShowServiceTest {

    private MovieShowService movieShowService;
    @Mock
    private MovieShowRepository movieShowRepository;
    @Mock
    private TheaterRepository theaterRepository;
    @Mock
    private MovieRepository movieRepository;
    @BeforeEach
    void setUp(){
        movieShowService = new MovieShowService(theaterRepository, movieShowRepository,movieRepository);
    }
    @Test
    void testGetAllMovies(){
        Movie m1 = new Movie("Title1", "Description1", "Genre1", "TestIMG");
        Theater t1 = new Theater("Name1", 100);
        MovieShow s1 = new MovieShow(LocalDate.now(), m1, t1, 1);
        when(movieShowRepository.findAll()).thenReturn(List.of(s1));
        List<MovieShowResponse> res = movieShowService.getAllMovieShows();
        assertEquals(1, res.size());
    }
}