package tn.esprit.tpfoyer.repositories;

import org.springframework.stereotype.Repository;

@Repository
public interface UniversiteRepository extends org.springframework.data.jpa.repository.JpaRepository<tn.esprit.tpfoyer.entity.Universite, Long> {
}
