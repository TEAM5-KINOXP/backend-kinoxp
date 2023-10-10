package dk.kea.kinoxp.api;

import dk.kea.kinoxp.dto.ReservationResponse;
import dk.kea.kinoxp.entity.Reservation;
import dk.kea.kinoxp.service.ReservationService;
import dk.kea.kinoxp.dto.ReservationRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/reservations")
public class ReservationController {
    ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/{username}")
    public List<ReservationResponse> getAllReservations(@PathVariable String username){
        List<ReservationResponse> res = reservationService.getReservationsForUser(username);
        return res;
    }
    @DeleteMapping("/{res_id}")
    public void deleteReservation(@PathVariable int res_id) {
        reservationService.deleteReservation(res_id);
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReservationResponse addReservation(@RequestBody ReservationRequest res){
        ReservationResponse r = reservationService.addReservation(res);
        return r;
    }
    @GetMapping
    public List<ReservationResponse> getAllReservations(){
       return reservationService.getAllReservations();
    }
}

