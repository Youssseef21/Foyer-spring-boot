package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entity.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation ajouterReservation(Reservation r);
    void supprimerReservation(String id);
    Reservation afficherReservationById(String id);
    List<Reservation> afficherReservations();

}
