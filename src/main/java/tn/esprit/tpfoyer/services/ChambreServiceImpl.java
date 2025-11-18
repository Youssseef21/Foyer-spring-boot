package tn.esprit.tpfoyer.services;

import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.repositories.ChambreRepository;
import tn.esprit.tpfoyer.repositories.ReservationRepository;

import java.util.HashSet;
import java.util.List;

@Service
public class ChambreServiceImpl implements IChambreService {
    final ChambreRepository chambreRepository;
    final ReservationRepository reservationRepository;

    public ChambreServiceImpl(ChambreRepository chambreRepository, ReservationRepository reservationRepository) {
        this.chambreRepository = chambreRepository;
        this.reservationRepository = reservationRepository;
    }

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

    @Override
    public Chambre creerChambreAvecReservation(Chambre chambre) {
                return chambreRepository.save(chambre);
    }

    @Override
    public Chambre reserverChambre(Long idChambre, String idReservation) {
        Chambre chambre = chambreRepository.findById(idChambre).get();
        Reservation reservation = reservationRepository.findById(idReservation).get();
        
        if (chambre.getReservations() == null) {
            chambre.setReservations(new HashSet<>());
        }
        
        chambre.getReservations().add(reservation);
        
        return chambreRepository.save(chambre);
    }

    @Override
    public Chambre annulerReservation(Long idChambre, String idReservation) {
        Chambre chambre = chambreRepository.findById(idChambre).get();
        Reservation reservation = reservationRepository.findById(idReservation).get();
        
        if (chambre.getReservations() != null) {
            chambre.getReservations().remove(reservation);
        }
        
        return chambreRepository.save(chambre);
    }
}
