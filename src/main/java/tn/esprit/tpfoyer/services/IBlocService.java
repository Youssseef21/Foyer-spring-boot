package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.dto.BlocDto;

import java.util.List;

public interface IBlocService {
    Bloc ajouterBloc(Bloc b);
    void supprimerBloc(Long id);
    Bloc afficherBlocById(Long id);
    List<Bloc> afficherBlocs();
    BlocDto afficherBlocDtoById(Long id);
}
