package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entity.Chambre;

import java.util.List;

public interface IChambreService {
    Chambre ajouterChambre(Chambre c);
    void supprimerChambre(Long id);
    Chambre afficherChambreById(Long id);
    List<Chambre> afficherChambres();
}
