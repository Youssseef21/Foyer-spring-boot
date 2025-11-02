package tn.esprit.tpfoyer.dto;

import lombok.*;
import tn.esprit.tpfoyer.entity.Typechambre;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChambreDto {
    private Typechambre typeC;
    private String nomBloc;
}
