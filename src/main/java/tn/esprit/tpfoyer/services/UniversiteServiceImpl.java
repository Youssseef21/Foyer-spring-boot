package tn.esprit.tpfoyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.repositories.FoyerRepository;
import tn.esprit.tpfoyer.repositories.UniversiteRepository;

import java.util.List;
@Service


public class UniversiteServiceImpl implements IUniversiteService {
    final UniversiteRepository universiteRepository;
    final FoyerRepository foyerRepository;

    public UniversiteServiceImpl(UniversiteRepository universiteRepository, FoyerRepository foyerRepository) {
        this.universiteRepository = universiteRepository;
        this.foyerRepository = foyerRepository;
    }

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

    @Override
    public Universite assignUniversiteToFoyer(Long universityId, Long idF) {
        Universite u = universiteRepository.findById(universityId).get();
        Foyer f = foyerRepository.findById(idF).get();
        u.setFoyer(f);
        return universiteRepository.save(u);
    }
    public Universite addUniversiteDandAssignToFoyer(Universite u, Long idF) {
        Foyer f = foyerRepository.findById(idF).get();
        u.setFoyer(f);
        return universiteRepository.save(u);
    }
    @Override
    public Universite addUniversiteandFoyerANdAssignToFoyer(Universite u) {
        return universiteRepository.save(u);
    }
    @Override
    public Universite removeUniversiteFromFoyer(Long universityId) {
        Universite u = universiteRepository.findById(universityId).get();
        u.setFoyer(null);
        return universiteRepository.save(u);
    }
    @Override
    public List<Universite> findByNomUniversite(String nomUniversite) {
        return universiteRepository.findByNomUniversite(nomUniversite);}
    @Override
    public int updateUniversiteByAdresse(String adresse, Long idUniversite) {
        return universiteRepository.updateUniversiteByAdresse(adresse, idUniversite);}



}
