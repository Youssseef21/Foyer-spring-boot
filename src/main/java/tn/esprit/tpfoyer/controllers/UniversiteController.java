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





    @PutMapping("/assignTOu/{univers}/{idF}")
    void assignUniversiteToFoyer(@PathVariable("univers") Long univers,@PathVariable("idF") Long idF){
        universiteService.assignUniversiteToFoyer(univers,idF);
    }
//    @PostMapping("/add-universite-and-foyer")
//    Universite addUniversiteandFoyerANdAssignToFoyer(@RequestBody Universite u){
//        return universiteService.addUniversiteandFoyerANdAssignToFoyer(u);
//    }
    @PutMapping("/remove-universite-from-foyer/{universityId}")
    void removeUniversiteFromFoyer(@PathVariable("universityId") Long universityId){
        universiteService.removeUniversiteFromFoyer(universityId);
    }

    @PostMapping("/add-universite-foyer/{idF}")
    Universite addUniversiteDandAssignToFoyer(@RequestBody Universite u, @PathVariable("idF") Long idF){
        return universiteService.addUniversiteDandAssignToFoyer(u,idF);
    }
}
