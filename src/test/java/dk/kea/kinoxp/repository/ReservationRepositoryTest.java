package dk.kea.kinoxp.repository;

import dk.kea.kinoxp.entity.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReservationRepositoryTest {

    @Mock
    ReservationRepository reservationRepository;

    @Test
    void testFindByUserUsername() {
        User user = new User("testtest", "testtest", "testtest", "testtest", "testtest");
        Movie movie = new Movie("title", "description", "genre", "img");
        Theater theater = new Theater("name", 1);
        MovieShow show = new MovieShow(LocalDate.now(), movie, theater, 1);
        Reservation res = new Reservation(show, user, 1);

        when(reservationRepository.findByUserUsername("testtest")).thenReturn(List.of(res));

        List<Reservation> result = reservationRepository.findByUserUsername("testtest");

        assertEquals(1, result.size());
    }
}