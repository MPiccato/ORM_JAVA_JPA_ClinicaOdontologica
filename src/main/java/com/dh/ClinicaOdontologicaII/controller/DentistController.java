package com.dh.ClinicaOdontologicaII.controller;

import com.dh.ClinicaOdontologicaII.entities.Dentist;
import com.dh.ClinicaOdontologicaII.services.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dentist")
public class DentistController {

    private final DentistService dentistService;

    @Autowired
    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

   @PostMapping
    public Dentist save(@RequestBody Dentist dentist) {
        return dentistService.save(dentist);
   }

   @GetMapping("/all")
    public List<Dentist> getAll() {
        return dentistService.findAll();
   }

   @GetMapping("/id/{id}")
    public ResponseEntity<Dentist> findById(@PathVariable Integer id) {
        Optional<Dentist> dentistWanted = dentistService.findById(id);

        if (dentistWanted.isPresent()) {
            return ResponseEntity.ok(dentistWanted.get());

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }


        //return dentistWanted.get() //Necesito usar el get porque es un optional
   }
}
