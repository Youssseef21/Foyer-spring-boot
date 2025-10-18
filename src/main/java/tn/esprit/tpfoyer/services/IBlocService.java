package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entity.Bloc;

import java.util.List;

public interface IBlocService {
    Bloc ajouterBloc(Bloc b);
    void supprimerBloc(Long id);
    Bloc afficherBlocById(Long id);
    List<Bloc> afficherBlocs();
}
