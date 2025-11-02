package tn.esprit.tpfoyer.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.dto.ChambreDto;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.services.ChambreServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/chambreController")
@Tag(name = "Chambre Management")
@RequiredArgsConstructor
public class ChambreController {
    private final ChambreServiceImpl chambreService;

    @Operation(summary = "Add a new Chambre")
    @PostMapping("/add-chambre")
    Chambre addChambre(@RequestBody Chambre c) {
        return chambreService.ajouterChambre(c);
    }

    @Operation(summary = "Get all Chambres")
    @GetMapping("/get-all-chambres")
    List<Chambre> getAllChambres() {
        return chambreService.afficherChambres();
    }

    @Operation(summary = "Get all Chambres as DTOs (type and bloc name)")
    @GetMapping("/get-all-chambres-dto")
    List<ChambreDto> getAllChambresDto() {
        return chambreService.afficherChambresDto();
    }

    @Operation(summary = "Get Chambre by ID as DTO")
    @GetMapping("/get-chambre-dto-by-id/{id}")
    ChambreDto getChambreDtoById(@PathVariable("id") Long id) {
        return chambreService.afficherChambreDtoById(id);
    }
}
