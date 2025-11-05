package tn.esprit.tpfoyer.services;

import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.repositories.BlocRepository;
import tn.esprit.tpfoyer.dto.BlocDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
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

    // Conversion Entité -> DTO
    private BlocDto convertToDto(Bloc bloc) {
        return new BlocDto(bloc.getNomBloc());
    }

    public List<BlocDto> afficherBlocsDto() {
        return blocRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public BlocDto afficherBlocDtoById(Long id) {
        Bloc bloc = blocRepository.findById(id)
                .get();
        return convertToDto(bloc);
    }
}
