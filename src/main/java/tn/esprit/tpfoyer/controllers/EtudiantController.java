package tn.esprit.tpfoyer.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.services.IEtudiantService;

import java.util.List;

@RestController
@RequestMapping("/EtudiantController")
@AllArgsConstructor
public class EtudiantController {
    final IEtudiantService etudiantService;
    @PostMapping("/add-etudiant")
    void addEtudiant(@RequestBody Etudiant e){
        etudiantService.ajouterEtudiant(e);
    }
    @PutMapping("/update-etudiant")
    void updateEtudiant(@RequestBody Etudiant e){
        etudiantService.ajouterEtudiant(e);}
    @DeleteMapping("/delete-etudiant/{id}")
    void deleteEtudiant(@PathVariable("id") Long id){
        etudiantService.supprimerEtudiant(id);}
    @GetMapping("/get-all-etudiants")
    List<Etudiant> getAllEtudiants(){
        return etudiantService.afficherEtudiants();}
    @GetMapping("/get-etudiant-by-id/{id}")
    Etudiant getEtudiantById(@PathVariable("id") Long id){
        return etudiantService.afficherEtudiantById(id);}


}
