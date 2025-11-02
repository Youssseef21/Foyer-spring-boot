package tn.esprit.tpfoyer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.tpfoyer.dto.ChambreDto;
import tn.esprit.tpfoyer.entity.Chambre;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChambreMapper {
    
    @Mapping(source = "bloc.nomBloc", target = "nomBloc")
    @Mapping(source = "typeC", target = "typeC")
    ChambreDto toDto(Chambre chambre);
    
    List<ChambreDto> toDtoList(List<Chambre> chambres);
}
