package tn.esprit.tpfoyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repositories.FoyerRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class FoyerServiceImpl implements IFoyerService {
    final FoyerRepository foyerRepository;

    public FoyerServiceImpl(FoyerRepository foyerRepository) {
        this.foyerRepository = foyerRepository;
    }

    @Override
    public Foyer ajouterFoyer(Foyer f) {
        return  foyerRepository.save(f);
    }

    @Override
    public void supprimerFoyer(Long id) {
        foyerRepository.deleteById(id);
    }

    @Override
    public List<Foyer> afficherFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer afficherFoyerById(Long id) {
        return foyerRepository.findById(id).get();
    }
}
