package tn.esprit.tpfoyer.repositories;

import org.springframework.stereotype.Repository;

@Repository
public interface FoyerRepository extends org.springframework.data.jpa.repository.JpaRepository<tn.esprit.tpfoyer.entity.Foyer, Long> {
}
