package tn.esprit.tpfoyer.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.services.IReservationService;

@RestController
@RequestMapping("/reservations")
@AllArgsConstructor
public class ReservationController {
    final IReservationService reservationService;

    public ReservationController(IReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/add-reservation")
    void addReservation(@RequestBody Reservation r){
        reservationService.ajouterReservation(r);
    }
    @PutMapping("/update-reservation")
    void updateReservation(@RequestBody Reservation r){
        reservationService.ajouterReservation(r);}
    @DeleteMapping("/delete-reservation/{id}")
    void deleteReservation(@PathVariable("id") String id){
        reservationService.supprimerReservation(id);}
    @GetMapping("/get-all-reservations")
    java.util.List<Reservation> getAllReservations(){
        return reservationService.afficherReservations();}
    @GetMapping("/get-reservation-by-id/{id}")
    Reservation getReservationById(@PathVariable("id") String id){
        return reservationService.afficherReservationById(id);}
}
