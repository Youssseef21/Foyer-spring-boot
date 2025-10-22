package tn.esprit.tpfoyer.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.services.IFoyerService;

@RestController
@RequestMapping("/foyerController")
@AllArgsConstructor
public class FoyerController {
    final IFoyerService foyerService;

    public FoyerController(IFoyerService foyerService) {
        this.foyerService = foyerService;
    }

    @PostMapping("/add-foyer")
    Foyer addFoyer(@RequestBody Foyer f){
        return foyerService.ajouterFoyer(f);
    }
@PutMapping("/update-foyer")
    Foyer updateFoyer(@RequestBody Foyer f){
        return foyerService.ajouterFoyer(f);
    }
    @DeleteMapping("/delete-foyer/{id}")
    void deleteFoyer(@PathVariable("id") Long id){
        foyerService.supprimerFoyer(id);
    }
    @GetMapping("/get-all-foyers")
    java.util.List<Foyer> getAllFoyers(){
        return foyerService.afficherFoyers();
    }
    @GetMapping("/get-foyer-by-id/{id}")
    Foyer getFoyerById(@PathVariable("id") Long id){
        return foyerService.afficherFoyerById(id);
    }
    @DeleteMapping("/remove-foyer/{id}")
    void removeFoyer(@PathVariable("id") Long id){
        foyerService.supprimerFoyer(id);
    }



}
