package tn.esprit.tpfoyer.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String> {
}
