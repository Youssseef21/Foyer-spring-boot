package tn.esprit.tpfoyer.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.entity.*;

import java.util.List;

@Repository
public interface UniversiteRepository extends JpaRepository<Universite, Long> {
@Query("SELECT u FROM Universite u WHERE u.adresse = :nomUniversite")
List<Universite> findByNomUniversite(@Param("nomUniversite") String nomUniversite);
@Modifying
@Transactional
    @Query("UPDATE Universite u SET u.adresse = :adresse WHERE u.idUniversite = :idUniversite")
    int updateUniversiteByAdresse(@Param("adresse") String adresse, @Param("idUniversite") Long idUniversite);

}
