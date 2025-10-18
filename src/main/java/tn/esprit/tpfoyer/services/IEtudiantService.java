package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entity.Etudiant;

import java.util.List;

public interface IEtudiantService {
    Etudiant ajouterEtudiant(Etudiant e);
    void supprimerEtudiant(Long id);
    Etudiant afficherEtudiantById(Long id);
    List<Etudiant> afficherEtudiants();
}
