package tn.esprit.tpfoyer.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.dto.BlocDto;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.services.BlocServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/blocController")
@Tag(name = "Bloc Management")
@RequiredArgsConstructor
public class BlocController {
    private final BlocServiceImpl blocService;

    @Operation(summary = "Add a new Bloc")
    @PostMapping("/add-bloc")
    void addBloc(@RequestBody Bloc b) {
        blocService.ajouterBloc(b);
    }

    @Operation(summary = "Update a Bloc")
    @PutMapping("/update-bloc")
    void updateBloc(@RequestBody Bloc b) {
        blocService.ajouterBloc(b);
    }

    @Operation(summary = "Delete a Bloc by ID")
    @DeleteMapping("/delete-bloc/{id}")
    void deleteBloc(@PathVariable("id") Long id) {
        blocService.supprimerBloc(id);
    }

    @Operation(summary = "Get all Blocs")
    @GetMapping("/get-all-blocs")
    List<Bloc> getAllBlocs() {
        return blocService.afficherBlocs();
    }

    @Operation(summary = "Get Bloc by ID")
    @GetMapping("/get-bloc-by-id/{id}")
    Bloc getBlocById(@PathVariable("id") Long id) {
        return blocService.afficherBlocById(id);
    }

    @Operation(summary = "Get all Blocs as DTOs (only names)")
    @GetMapping("/get-all-blocs-dto")
    List<BlocDto> getAllBlocsDto() {
        return blocService.afficherBlocsDto();
    }

    @Operation(summary = "Get Bloc by ID as DTO (only name)")
    @GetMapping("/get-bloc-dto-by-id/{id}")
    BlocDto getBlocDtoById(@PathVariable("id") Long id) {
        return blocService.afficherBlocDtoById(id);
    }
}
