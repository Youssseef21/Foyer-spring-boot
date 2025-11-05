package tn.esprit.tpfoyer.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity

public class Universite {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idUniversite;

        private String nomUniversite;
        private String adresse;

        // Relation 1-1 avec Foyer (une université possède un foyer)
        @OneToOne(cascade = CascadeType.ALL)
        private Foyer foyer;



}

