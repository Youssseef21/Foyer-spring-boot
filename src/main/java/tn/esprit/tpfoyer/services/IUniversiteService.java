package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entity.Universite;

import java.util.List;

public interface IUniversiteService {
    Universite ajouterUniversite(Universite u);
    void supprimerUniversite(Long id);
    Universite afficherUniversiteById(Long id);
    List<Universite> afficherUniversites();
    Universite assignUniversiteToFoyer(Long universityId, Long idF);
    Universite addUniversiteDandAssignToFoyer(Universite u, Long idF);
    Universite addUniversiteandFoyerANdAssignToFoyer(Universite u);
    Universite removeUniversiteFromFoyer(Long universityId);
    List<Universite> findByNomUniversite(String nomUniversite);
    int updateUniversiteByAdresse(String adresse, Long idUniversite);
}
