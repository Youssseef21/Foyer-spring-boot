package tn.esprit.tpfoyer.mapper;

import org.junit.jupiter.api.Test;
import tn.esprit.tpfoyer.dto.BlocDto;
import tn.esprit.tpfoyer.entity.Bloc;

import static org.junit.jupiter.api.Assertions.*;

class BlocMapperTest {

    @Test
    void toDto_should_map_entity_to_dto() {
        Bloc e = new Bloc();
        // ...existing code...
        e.setIdBloc(10L);
        e.setNomBloc("Bloc A");
        e.setCapaciteBloc(120L);

        BlocDto dto = BlocMapper.toDto(e);

        assertNotNull(dto);
        assertEquals(10L, dto.getId());
        assertEquals("Bloc A", dto.getName());
        assertEquals(120L, dto.getCapacity());
    }

    @Test
    void toEntity_should_map_dto_to_entity() {
        BlocDto dto = new BlocDto().setId(5L).setName("Bloc B").setCapacity(80L);

        Bloc e = BlocMapper.toEntity(dto);

        assertNotNull(e);
        assertEquals(5L, e.getIdBloc());
        assertEquals("Bloc B", e.getNomBloc());
        assertEquals(80L, e.getCapaciteBloc());
    }
}

