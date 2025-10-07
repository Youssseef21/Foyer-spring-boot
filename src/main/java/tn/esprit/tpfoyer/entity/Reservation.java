package tn.esprit.tpfoyer.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Reservation {
    @Id
    private String idReservation;
    private Date anneeUniversitaire;

    private boolean estValide;

    // Relation N-N : Une réservation peut concerner plusieurs étudiants et vice-versa
    @ManyToMany
    private Set<Etudiant> etudiants;

}
