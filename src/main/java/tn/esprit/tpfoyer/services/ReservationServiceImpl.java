package tn.esprit.tpfoyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.repositories.ReservationRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservationService {
    final ReservationRepository reservationRepository;
    @Override
    public Reservation ajouterReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public void supprimerReservation(String id) {
        reservationRepository.deleteById(id);

    }

    @Override
    public Reservation afficherReservationById(String id) {
        return reservationRepository.findById(id).get();
    }

    @Override
    public List<Reservation> afficherReservations() {
        return reservationRepository.findAll();
    }
}
