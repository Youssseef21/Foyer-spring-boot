package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entity.Foyer;

import java.util.List;

public interface IFoyerService {
Foyer ajouterFoyer(Foyer f);
void supprimerFoyer(Long id);
List<Foyer> afficherFoyers();
Foyer afficherFoyerById(Long id);
List<Foyer> findByNomFoyer(String nomFoyer);
List<Foyer> extraireFoyerduBloc(String nomBloc);

}
