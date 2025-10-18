package tn.esprit.tpfoyer.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.services.IChambreService;

@RestController
@RequestMapping("/chambreController")
@AllArgsConstructor
public class ChambreController {
    final IChambreService chambreService;
    @PostMapping("/add-chambre")
    void addChambre(@RequestBody Chambre c){
        chambreService.ajouterChambre(c);
    }
    @PutMapping("/update-chambre")
    void updateChambre(@RequestBody Chambre c){
        chambreService.ajouterChambre(c);}
    @DeleteMapping("/delete-chambre/{id}")
    void deleteChambre(@PathVariable("id") Long id){
        chambreService.supprimerChambre(id);}
    @GetMapping("/get-all-chambres")
    java.util.List<Chambre> getAllChambres(){
        return chambreService.afficherChambres();}
    @GetMapping("/get-chambre-by-id/{id}")
    Chambre getChambreById(@PathVariable("id") Long id){
        return chambreService.afficherChambreById(id);}
}
