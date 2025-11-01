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

    //Crear un dentista
   @PostMapping("/save")
    public Dentist save(@RequestBody Dentist dentist) {
        return dentistService.save(dentist);
   }

   //Listar los dentistas
   @GetMapping("/all")
    public List<Dentist> getAll() {
        return dentistService.findAll();
   }

   //Busca por id un dentista
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

   //Actualizar un dentista
   @PutMapping("/update")
    public Dentist update(@RequestBody Dentist dentist) {
        Optional<Dentist> optionalDentist = dentistService.findById(dentist.getId());

        if (optionalDentist.isPresent()) {
            dentistService.update(dentist);
            return dentist;
        } else {
            return dentist;
        }


   }

   //Con deleteMapping estamos eliminando un odontólogo de la base de datos
   @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Integer id) {
        Optional<Dentist> optionalDentist = dentistService.findById(id);
        if (optionalDentist.isPresent()) {
            dentistService.delete(id);
            return "Se eliminó el odontólogo con id: " + id;
        } else {
            return "No se encontró el odontólogo con id: " + id;
        }

   }
}
