package tn.esprit.tpfoyer.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.entity.*;

import java.util.List;

@Repository
public interface FoyerRepository extends JpaRepository<Foyer, Long> {
    @Query("SELECT f FROM Foyer f WHERE f.nomFoyer = :nomFoyer")
    List<Foyer> findByNomFoyer(@Param("nomFoyer") String nomFoyer);
    @Query("select foy from Foyer foy join foy.blocs bloc where bloc.nomBloc = :nomBloc")
    List<Foyer> findByNomBloc(@Param("nomBloc") String nomBloc);
}
