package cloud.reto345.service;

import cloud.reto345.model.Reservation;
import cloud.reto345.model.custom.CountClient;
import cloud.reto345.model.custom.StatusAmount;
import cloud.reto345.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    public Reservation update(Reservation c){
        if(c.getIdReservation()!=null){
            Optional<Reservation> raux=reservationRepository.getReservation(c.getIdReservation());
            if(!raux.isEmpty()){
                if(c.getStartDate()!=null){
                    raux.get().setStartDate(c.getStartDate());
                }
                if(c.getDevolutionDate()!=null){
                    raux.get().setDevolutionDate(c.getDevolutionDate());
                }
                if(c.getStatus()!=null){
                    raux.get().setStatus(c.getStatus());
                }
                return reservationRepository.save(raux.get());
            }
        }
        return c;

    }

    public boolean deleteReservation(int idReservation) {
        Optional <Reservation> c=getReservation(idReservation);
        if(!c.isEmpty()){
            reservationRepository.delete(c.get());
            return true;
        }
        return false;
    }

    public StatusAmount reportStatusService (){
        List<Reservation>completed= reservationRepository.getReservationByStatus("completed");
        List<Reservation>cancelled= reservationRepository.getReservationByStatus("cancelled");

        return new StatusAmount(completed.size(), cancelled.size() );
    }

    public List<Reservation> getReservationPeriod (String dateOne, String dateTwo){
        SimpleDateFormat parser = new SimpleDateFormat ("yyyy-MM-dd");

        Date datoUno = new Date();
        Date datoDos = new Date();

        try{
            datoUno = parser.parse(dateOne);
            datoDos = parser.parse(dateTwo);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return reservationRepository.getReservationPeriod(datoUno, datoDos);
        }else{
            return new ArrayList<>();
        }
    }


    public List<CountClient> getTopClient(){
        return reservationRepository.getTopClient();
    }
}
