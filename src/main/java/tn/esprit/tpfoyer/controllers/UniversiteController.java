package tn.esprit.tpfoyer.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.services.IUniversiteService;

@RestController
@RequestMapping("/universiteController")

public class UniversiteController {
    final IUniversiteService universiteService;

    public UniversiteController(IUniversiteService universiteService) {
        this.universiteService = universiteService;
    }

    @PostMapping("add-universite")
    Universite addUniversite(@RequestBody Universite u){
        return universiteService.ajouterUniversite(u);
    }
    @PutMapping("/update-universite")
    Universite updateUniversite(@RequestBody Universite u){
        return universiteService.ajouterUniversite(u);}
    @DeleteMapping("/delete-universite/{id}")
    void deleteUniversite(@PathVariable("id") Long id){
        universiteService.supprimerUniversite(id);}
    @GetMapping("/get-all-universites")
    java.util.List<Universite> getAllUniversites(){
        return universiteService.afficherUniversites();}
    @GetMapping("/get-universite-by-id/{id}")
    Universite getUniversiteById(@PathVariable("id") Long id){
        return universiteService.afficherUniversiteById(id);}
}
