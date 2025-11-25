package tn.esprit.tpfoyer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChambre;

    private Long numeroChambre;

    @Enumerated(EnumType.STRING)
    private Typechambre typeC;

    // Relation N-1 : Plusieurs chambres appartiennent à un bloc
    @ManyToOne
    @JsonIgnore
    private Bloc bloc;

    // Relation 1-N : Une chambre peut avoir plusieurs réservations
    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Reservation> reservations;

}
