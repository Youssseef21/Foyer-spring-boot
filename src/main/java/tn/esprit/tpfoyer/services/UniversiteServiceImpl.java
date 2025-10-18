package tn.esprit.tpfoyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.repositories.UniversiteRepository;

import java.util.List;
@Service
@AllArgsConstructor

public class UniversiteServiceImpl implements IUniversiteService {
    final UniversiteRepository universiteRepository;
    @Override
    public Universite ajouterUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public void supprimerUniversite(Long id) {
        universiteRepository.deleteById(id);

    }

    @Override
    public Universite afficherUniversiteById(Long id) {
        return universiteRepository.findById(id).get();
    }

    @Override
    public List<Universite> afficherUniversites() {
        return universiteRepository.findAll();
    }
}
