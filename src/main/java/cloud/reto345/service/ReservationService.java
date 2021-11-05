package cloud.reto345.service;


import cloud.reto345.model.Reservation;
import cloud.reto345.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int idReservation){
        return reservationRepository.getReservation(idReservation);
    }

    public Reservation save(Reservation c){
        if(c.getIdReservation()==null){
            return reservationRepository.save(c);
        }else{
            Optional<Reservation> raux=reservationRepository.getReservation(c.getIdReservation());
            if(raux.isEmpty()){
                return reservationRepository.save(c);
            }else{
                return c;
            }
        }

    }
}
