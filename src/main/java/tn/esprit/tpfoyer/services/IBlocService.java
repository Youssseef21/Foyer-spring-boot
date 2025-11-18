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
    
    // Exercice 1 - Affectations Bloc-Foyer
    Bloc creerBlocAvecFoyer(Bloc bloc);
    Bloc affecterBlocAFoyer(Long idBloc, Long idFoyer);
    Bloc desaffecterBlocDeFoyer(Long idBloc);
}
