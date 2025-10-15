package tn.esprit.tpfoyer.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.entity.*;
@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}
