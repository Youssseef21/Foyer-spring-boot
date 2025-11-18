package tn.esprit.tpfoyer.services;

import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repositories.BlocRepository;
import tn.esprit.tpfoyer.repositories.FoyerRepository;
import tn.esprit.tpfoyer.dto.BlocDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlocServiceImpl implements IBlocService {
    final BlocRepository blocRepository;
    final FoyerRepository foyerRepository;

    public BlocServiceImpl(BlocRepository blocRepository, FoyerRepository foyerRepository) {
        this.blocRepository = blocRepository;
        this.foyerRepository = foyerRepository;
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

    @Override
    public List<BlocDto> afficherBlocsDto() {
        return blocRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public BlocDto afficherBlocDtoById(Long id) {
        Bloc bloc = blocRepository.findById(id).get();
        return convertToDto(bloc);
    }

    @Override
    public Bloc creerBlocAvecFoyer(Bloc bloc) {
               return blocRepository.save(bloc);
    }

    @Override
    public Bloc affecterBlocAFoyer(Long idBloc, Long idFoyer) {
        Bloc bloc = blocRepository.findById(idBloc).get();
        Foyer foyer = foyerRepository.findById(idFoyer).get();
        
        bloc.setFoyer(foyer);
        
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc desaffecterBlocDeFoyer(Long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).get();
        bloc.setFoyer(null);
        
        return blocRepository.save(bloc);
    }
    @Override
    public List<Bloc> findByFoyerIsNull() {
        return blocRepository.findByFoyerIsNull();
    }
    @Override
    public List<Bloc> findByCapaciteBlocGreaterThan(int capacite) {
        return blocRepository.findByCapaciteBlocGreaterThan(30);}
    @Override
    public List<Bloc> findByNomBlocStartingWith(String start) {
        return blocRepository.findByNomBlocStartingWith(start); }
    @Override
    public List<Bloc> findByNomBlocStartingWithAndCapaciteBlocGreaterThan(String start, int capacite) {
        return blocRepository.findByNomBlocStartingWithAndCapaciteBlocGreaterThan(start, capacite);
    }
}
