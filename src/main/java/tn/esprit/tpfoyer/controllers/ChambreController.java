package tn.esprit.tpfoyer.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.entity.Typechambre;
import tn.esprit.tpfoyer.services.IChambreService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/chambreController")
@Tag(name = "Chambre Management")
public class ChambreController {
    final IChambreService chambreService;

    public ChambreController(IChambreService chambreService) {
        this.chambreService = chambreService;
    }

    @Operation(summary = "Add a new Chambre")
    @PostMapping("/add-chambre")
    void addChambre(@RequestBody Chambre c) {
        chambreService.ajouterChambre(c);
    }

    @Operation(summary = "Update a Chambre")
    @PutMapping("/update-chambre")
    void updateChambre(@RequestBody Chambre c) {
        chambreService.ajouterChambre(c);
    }

    @Operation(summary = "Delete a Chambre by ID")
    @DeleteMapping("/delete-chambre/{id}")
    void deleteChambre(@PathVariable("id") Long id) {
        chambreService.supprimerChambre(id);
    }

    @Operation(summary = "Get all Chambres")
    @GetMapping("/get-all-chambres")
    List<Chambre> getAllChambres() {
        return chambreService.afficherChambres();
    }

    @Operation(summary = "Get Chambre by ID")
    @GetMapping("/get-chambre-by-id/{id}")
    Chambre getChambreById(@PathVariable("id") Long id) {
        return chambreService.afficherChambreById(id);
    }

    @Operation(summary = "Créer une Chambre avec une Réservation")
    @PostMapping("/creer-chambre-avec-reservation")
    public void  creerChambreAvecReservation(@RequestBody Chambre Chambre) {

        chambreService.creerChambreAvecReservation(Chambre) ;

    }


    @Operation(summary = "Affecter une Réservation")
    @PutMapping("/reserver-chambre/{idChambre}/{idReservation}")
    void reserverChambre(@PathVariable("idChambre") Long idChambre,
                        @PathVariable("idReservation") String idReservation) {
        chambreService.reserverChambre(idChambre, idReservation);
    }

    @Operation(summary = "Annuler une Réservation")
    @PutMapping("/annuler-reservation/{idChambre}/{idReservation}")
    void annulerReservation(@PathVariable("idChambre") Long idChambre,
                           @PathVariable("idReservation") String idReservation) {
        chambreService.annulerReservation(idChambre, idReservation);
    }
}
