package tn.esprit.tpfoyer.services;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.entity.Typechambre;
import tn.esprit.tpfoyer.repositories.ChambreRepository;
import tn.esprit.tpfoyer.repositories.ReservationRepository;

import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
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
    public List<Chambre> findByTypeC(Typechambre type) {
        return chambreRepository.findByTypeC(type);
    }
    public Optional<Chambre> findByNumeroChambre(Long numeroChambre) {
        return chambreRepository.findByNumeroChambre(numeroChambre);
    }
    
    @Override
    @Scheduled(cron = "0 */5 * * * *") // Execute every 5 minutes
    public void pourcentageChambreParTypeChambre() {
        List<Chambre> chambres = chambreRepository.findAll();
        long totalChambres = chambres.size();
        
        log.info("Nombre total des chambre: " + totalChambres);
        
        for (Typechambre type : Typechambre.values()) {
            long count = chambres.stream()
                    .filter(c -> c.getTypeC() == type)
                    .count();
            
            double percentage = totalChambres > 0 ? (count * 100.0 / totalChambres) : 0.0;
            
            log.info("Le pourcentage des chambres pour le type " + type + " est égale à " + percentage);
        }
    }

    @Override
    @Scheduled(cron = "0 */5 * * * *")
    @Transactional
    public void nbPlacesDisponibleParChambreAnneeEnCours() {
        List<Chambre> chambres = chambreRepository.findAll();
        int currentYear = Year.now().getValue();

        for (Chambre chambre : chambres) {
            int capacite = switch (chambre.getTypeC()) {
                case SIMPLE -> 1;
                case DOUBLE -> 2;
                case TRIPLE -> 3;
            };

            int occupees = 0;
            if (chambre.getReservations() != null) {
                for (Reservation reservation : chambre.getReservations()) {
                    if (reservation.isEstValide() && reservation.getAnneeUniversitaire() != null) {
                        LocalDate date = reservation.getAnneeUniversitaire().toInstant()
                                .atZone(ZoneId.systemDefault()).toLocalDate();
                        if (date.getYear() == currentYear) {
                            occupees += (reservation.getEtudiants() != null) ? reservation.getEtudiants().size() : 0;
                        }
                    }
                }
            }

            int disponibles = Math.max(0, capacite - occupees);
            if (disponibles == 0) {
                log.info("La chambre " + chambre.getTypeC() + " " + chambre.getNumeroChambre() + " est complete");
            } else {
                log.info("Le nombre de place disponible pour la chambre " + chambre.getTypeC() + " " + chambre.getNumeroChambre() + " est " + disponibles);
            }
        }
    }
}
