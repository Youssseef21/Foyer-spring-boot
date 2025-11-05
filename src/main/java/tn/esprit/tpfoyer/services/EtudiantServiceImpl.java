package tn.esprit.tpfoyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.repositories.EtudiantRepository;
import tn.esprit.tpfoyer.repositories.ReservationRepository;

import java.util.List;

@Service

public class EtudiantServiceImpl implements IEtudiantService {
    final EtudiantRepository etudiantRepository;
    final ReservationRepository reservationRepository;

    public EtudiantServiceImpl(EtudiantRepository etudiantRepository, ReservationRepository reservationRepository) {
        this.etudiantRepository = etudiantRepository;
        this.reservationRepository = reservationRepository;
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
    @Override
    public Reservation assignEtudiantToReservation(Long etudiantId, String reservationId) {
        Etudiant e = etudiantRepository.findById(etudiantId).get();
        Reservation r = reservationRepository.findById(reservationId).get();
        r.getEtudiants().add(e);
        return reservationRepository.save(r);
    }
    @Override
    public Reservation removeEtudiantFromReservation(Long etudiantId, String reservationId) {
        Etudiant e = etudiantRepository.findById(etudiantId).get();
        Reservation r = reservationRepository.findById(reservationId).get();
        r.getEtudiants().remove(e);
        return reservationRepository.save(r);}


}
