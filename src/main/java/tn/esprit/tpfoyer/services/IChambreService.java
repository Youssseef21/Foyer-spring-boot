package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.entity.Typechambre;

import java.util.List;
import java.util.Optional;

public interface IChambreService {
    Chambre ajouterChambre(Chambre c);
    void supprimerChambre(Long id);
    Chambre afficherChambreById(Long id);
    List<Chambre> afficherChambres();
    List<Chambre> findByTypeC(Typechambre type);
    Chambre creerChambreAvecReservation(Chambre chambre);
    Chambre reserverChambre(Long idChambre, String idReservation);
    Chambre annulerReservation(Long idChambre, String idReservation);
    Optional<Chambre> findByNumeroChambre(Long numeroChambre);
    
    // Service 02: Pourcentage des chambres par type (toutes les 5 minutes)
    void pourcentageChambreParTypeChambre();

    // Service 03: Nombre de places disponibles par chambre pour l'année en cours (toutes les 5 minutes)
    void nbPlacesDisponibleParChambreAnneeEnCours();
}
