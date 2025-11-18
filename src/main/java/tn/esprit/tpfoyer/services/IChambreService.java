package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.Reservation;

import java.util.List;

public interface IChambreService {
    Chambre ajouterChambre(Chambre c);
    void supprimerChambre(Long id);
    Chambre afficherChambreById(Long id);
    List<Chambre> afficherChambres();
    
    // Exercice 2 - Affectations Chambre-Réservation
    Chambre creerChambreAvecReservation(Chambre chambre);
    Chambre reserverChambre(Long idChambre, String idReservation);
    Chambre annulerReservation(Long idChambre, String idReservation);
}
