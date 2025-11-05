package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.entity.Reservation;

import java.util.List;

public interface IEtudiantService {
    Etudiant ajouterEtudiant(Etudiant e);
    void supprimerEtudiant(Long id);
    Etudiant afficherEtudiantById(Long id);
    List<Etudiant> afficherEtudiants();
    Reservation assignEtudiantToReservation(Long etudiantId, String reservationId);
    Reservation removeEtudiantFromReservation(Long etudiantId, String reservationId);

}
