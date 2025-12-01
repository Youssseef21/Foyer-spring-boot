package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.dto.BlocDto;
import tn.esprit.tpfoyer.entity.Bloc;

import java.util.List;

public interface IBlocService {
    Bloc ajouterBloc(Bloc b);
    void supprimerBloc(Long id);
    Bloc afficherBlocById(Long id);
    List<Bloc> afficherBlocs();
    
    // DTO methods
    List<BlocDto> afficherBlocsDto();
    BlocDto afficherBlocDtoById(Long id);
    List<Bloc> findByFoyerIsNull();
    List<Bloc> findByCapaciteBlocGreaterThan(int capacite);
    List<Bloc> findByNomBlocStartingWith(String start);
    List<Bloc> findByNomBlocStartingWithAndCapaciteBlocGreaterThan(String start, int capacite);
    // Exercice 1 - Affectations Bloc-Foyer
    Bloc creerBlocAvecFoyer(Bloc bloc);
    Bloc affecterBlocAFoyer(Long idBloc, Long idFoyer);
    Bloc desaffecterBlocDeFoyer(Long idBloc);
    
    // Service 01: Liste des chambres par bloc (toutes les minutes)
    void listeChambresParBloc();
}
