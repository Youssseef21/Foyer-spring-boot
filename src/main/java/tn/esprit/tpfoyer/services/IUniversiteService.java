package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entity.Universite;

import java.util.List;

public interface IUniversiteService {
    Universite ajouterUniversite(Universite u);
    void supprimerUniversite(Long id);
    Universite afficherUniversiteById(Long id);
    List<Universite> afficherUniversites();
}
