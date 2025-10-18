package tn.esprit.tpfoyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.repositories.ChambreRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class ChambreServiceImpl implements IChambreService {
    final ChambreRepository chambreRepository;
    @Override
    public Chambre ajouterChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public void supprimerChambre(Long id) {
        chambreRepository.deleteById(id);

    }

    @Override
    public Chambre afficherChambreById(Long id) {
        return chambreRepository.findById(id).get();
    }

    @Override
    public List<Chambre> afficherChambres() {
        return chambreRepository.findAll();
    }
}
