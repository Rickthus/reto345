package cloud.reto345.web;

import cloud.reto345.model.Reservation;
import cloud.reto345.model.custom.CountClient;
import cloud.reto345.model.custom.StatusAmount;
import cloud.reto345.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getReservation(){
        return reservationService.getAll();
    }

    @GetMapping("/{idReservation}")
    public Optional<Reservation> getReservation(@PathVariable("idReservation") int idReservation){
        return reservationService.getReservation(idReservation);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation c){
        return reservationService.save(c);

    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation c){
        return reservationService.update(c);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteReservation(@PathVariable("id") int idReservation){
        return reservationService.deleteReservation(idReservation);
    }

    @GetMapping("/report-status")
    public StatusAmount getReserv() {
        return reservationService.reportStatusService();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservationPeriod (@PathVariable("dateOne")String dateOne, @PathVariable("dateTwo")String dateTwo ){
        return reservationService.getReservationPeriod(dateOne, dateTwo);
    }

    @GetMapping("/report-clients")
    public List<CountClient> getTopClient() {
        return reservationService.getTopClient();
    }
}
