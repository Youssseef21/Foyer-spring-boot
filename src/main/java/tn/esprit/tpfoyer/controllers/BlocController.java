package tn.esprit.tpfoyer.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.services.IBlocService;

@RestController
@RequestMapping("/blocController")
@AllArgsConstructor
public class BlocController {
    final IBlocService blocService;
    @PostMapping("/add-bloc")
    void addBloc(@RequestBody Bloc b){
        blocService.ajouterBloc(b);
    }
    @PutMapping("/update-bloc")
    void updateBloc(@RequestBody Bloc b){
        blocService.ajouterBloc(b);}
    @DeleteMapping("/delete-bloc/{id}")
    void deleteBloc(@PathVariable("id") Long id){
        blocService.supprimerBloc(id);}
    @GetMapping("/get-all-blocs")
    java.util.List<Bloc> getAllBlocs(){
        return blocService.afficherBlocs();}
    @GetMapping("/get-bloc-by-id/{id}")
    Bloc getBlocById(@PathVariable("id") Long id){
        return blocService.afficherBlocById(id);
    }
}
