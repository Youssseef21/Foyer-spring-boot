package tn.esprit.tpfoyer.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tn.esprit.tpfoyer.dto.BlocDto;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.services.IBlocService;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BlocController.class)
class BlocControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper om;

    @MockBean
    IBlocService blocService;

    @Test
    void addBloc_should_accept_dto_payload() throws Exception {
        BlocDto dto = new BlocDto().setName("Bloc A").setCapacity(120L);

        mvc.perform(post("/blocController/add-bloc")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(dto)))
                .andExpect(status().isOk());
    }

    @Test
    void getAllBlocs_should_return_dto_list() throws Exception {
        Bloc b1 = new Bloc(); b1.setIdBloc(1L); b1.setNomBloc("A"); b1.setCapaciteBloc(100L);
        Bloc b2 = new Bloc(); b2.setIdBloc(2L); b2.setNomBloc("B"); b2.setCapaciteBloc(200L);
        given(blocService.afficherBlocs()).willReturn(List.of(b1, b2));

        mvc.perform(get("/blocController/get-all-blocs"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("A"))
                .andExpect(jsonPath("$[0].capacity").value(100))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("B"))
                .andExpect(jsonPath("$[1].capacity").value(200));
    }
}

