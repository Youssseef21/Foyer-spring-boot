package tn.esprit.tpfoyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.repositories.BlocRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class BlocServiceImpl implements IBlocService {
    final BlocRepository blocRepository;

    public BlocServiceImpl(BlocRepository blocRepository) {
        this.blocRepository = blocRepository;
    }

    @Override
    public Bloc ajouterBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public void supprimerBloc(Long id) {
        blocRepository.deleteById(id);

    }

    @Override
    public Bloc afficherBlocById(Long id) {
        return blocRepository.findById(id).get();
    }

    @Override
    public List<Bloc> afficherBlocs() {
        return blocRepository.findAll();
    }
}
