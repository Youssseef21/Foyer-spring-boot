package tn.esprit.tpfoyer.repositories;

import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends org.springframework.data.jpa.repository.JpaRepository<tn.esprit.tpfoyer.entity.Reservation, Long> {
}
