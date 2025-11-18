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
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;
    private String nomBloc;
    private Long capaciteBloc;

    // Relation N-1 : Plusieurs blocs appartiennent à un foyer
    @ManyToOne(cascade = CascadeType.ALL)
    private Foyer foyer;

    // Relation 1-N : Un bloc contient plusieurs chambres
    @OneToMany(mappedBy = "bloc")
    private java.util.Set<Chambre> chambres;
}
