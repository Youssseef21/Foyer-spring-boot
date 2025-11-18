package tn.esprit.tpfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.entity.*;

import java.util.List;

@Repository
public interface BlocRepository extends JpaRepository<Bloc, Long> {
    List<Bloc> findByFoyerIsNull();
    List<Bloc> findByCapaciteBlocGreaterThan(int capacite);
    List<Bloc> findByNomBlocStartingWith(String start);
    List<Bloc> findByNomBlocStartingWithAndCapaciteBlocGreaterThan(String start, int capacite);

}
