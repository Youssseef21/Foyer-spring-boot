package tn.esprit.tpfoyer.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.dto.BlocDto;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.services.IBlocService;

import java.util.List;

@RestController
@RequestMapping("/blocController")
@Tag(name = "Bloc Management")
public class BlocController {
    final IBlocService blocService;

    public BlocController(IBlocService blocService) {
        this.blocService = blocService;
    }

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

//    @Operation(summary = "Créer un Bloc avec son Foyer")
//    @PostMapping("/creer-bloc-avec-foyer")
//    void creerBlocAvecFoyer(@RequestBody Bloc bloc) {
//        blocService.creerBlocAvecFoyer(bloc);
//    }

    @Operation(summary = "Affecter un Bloc à un Foyer")
    @PutMapping("/affecter-bloc-foyer/{idBloc}/{idFoyer}")
    void affecterBlocAFoyer(@PathVariable("idBloc") Long idBloc, 
                           @PathVariable("idFoyer") Long idFoyer) {
        blocService.affecterBlocAFoyer(idBloc, idFoyer);
    }

    @Operation(summary = "Désaffecter un Bloc de son Foyer")
    @PutMapping("/desaffecter-bloc-foyer/{idBloc}")
    void desaffecterBlocDeFoyer(@PathVariable("idBloc") Long idBloc) {
        blocService.desaffecterBlocDeFoyer(idBloc);
    }
    @GetMapping("/blocs-without-foyer")
    List<Bloc> getBlocsWithoutFoyer() {
        return blocService.findByFoyerIsNull();}
    @GetMapping("/blocs-with-capacity-greater-than/{capacity}")
    List<Bloc> getBlocsWithCapacityGreaterThan(@PathVariable("capacity") int capacity) {
        return blocService.findByCapaciteBlocGreaterThan(capacity);}
    @GetMapping("/blocs-starting-with/{start}")
    List<Bloc> getBlocsStartingWith(@PathVariable("start") String start) {
        return blocService.findByNomBlocStartingWith(start);}
    @GetMapping("/blocs-starting-with-and-capacity-greater-than/{start}/{capacity}")
    List<Bloc> getBlocsStartingWithAndCapacityGreaterThan(@PathVariable("start") String start,
                                                          @PathVariable("capacity") int capacity) {
        return blocService.findByNomBlocStartingWithAndCapaciteBlocGreaterThan(start, capacity);}
}
