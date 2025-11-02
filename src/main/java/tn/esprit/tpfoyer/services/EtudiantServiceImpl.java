package tn.esprit.tpfoyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.repositories.EtudiantRepository;

import java.util.List;

@Service

public class EtudiantServiceImpl implements IEtudiantService {
    final EtudiantRepository etudiantRepository;

    public EtudiantServiceImpl(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public Etudiant ajouterEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public void supprimerEtudiant(Long id) {
        etudiantRepository.deleteById(id);

    }

    @Override
    public Etudiant afficherEtudiantById(Long id) {
        return etudiantRepository.findById(id).get();
    }

    @Override
    public List<Etudiant> afficherEtudiants() {
        return etudiantRepository.findAll();
    }
}
