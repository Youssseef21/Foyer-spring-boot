package tn.esprit.tpfoyer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.dto.ChambreDto;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.mapper.ChambreMapper;
import tn.esprit.tpfoyer.repositories.ChambreRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChambreServiceImpl implements IChambreService {
    private final ChambreRepository chambreRepository;
    private final ChambreMapper chambreMapper;

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
        return chambreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chambre non trouvée avec l'ID: " + id));
    }

    @Override
    public List<Chambre> afficherChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public List<ChambreDto> afficherChambresDto() {

        return chambreMapper.toDtoList(chambreRepository.findAll());
    }

    @Override
    public ChambreDto afficherChambreDtoById(Long id) {
        Chambre chambre = afficherChambreById(id);
        return chambreMapper.toDto(chambre);
    }
}
