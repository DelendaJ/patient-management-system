package dev.delenda.patient.controller;

import dev.delenda.patient.model.Medications;
import dev.delenda.patient.model.Patients;
import dev.delenda.patient.services.MedicationService;
import dev.delenda.patient.services.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin("*")
public class MedicationController {

  private MedicationService medService;
  private PatientService patientService;

    public MedicationController(MedicationService medService) {
        this.medService = medService;
    }

 /*   @GetMapping("/{id}/medications")
    public ResponseEntity<Medications> patientMeds(@PathVariable Long id) {
        Optional<Medications> medication = medService.getAllPatientMeds(id);
        return medication.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }*/

    @PostMapping("/{id}/medications")
    public ResponseEntity<Medications> newMeds(@PathVariable Long id, @RequestBody Medications medication) {
        return new ResponseEntity<>(medService.newMeds(medication), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}/medications/{med_id}")
    public ResponseEntity<Boolean> destroy(Long id) {
        return new ResponseEntity<>(medService.destroyMeds(id), HttpStatus.OK);
    }


}
