package dev.delenda.patient.controller;

import dev.delenda.patient.entities.Medication;
import dev.delenda.patient.entities.Patient;
import dev.delenda.patient.services.MedicationService;
import dev.delenda.patient.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/api/patients")
@CrossOrigin
public class MedicationController {

    private MedicationService medService;
    private PatientService patientService;


    @Autowired
    public MedicationController(MedicationService medService, PatientService patientService) {
        this.medService = medService;
        this.patientService = patientService;
    }

    @PostMapping("/{id}/medications")
    public ResponseEntity<Patient> addNewMedsToPatient(@PathVariable UUID id, @RequestBody Medication meds) {
        return new ResponseEntity<>(this.medService.patientDrugs(id, meds), HttpStatus.CREATED);
    }

    @GetMapping("/{id}/medications")
    public ResponseEntity<Iterable<Medication>> getPatientMeds(@PathVariable UUID id, @RequestBody Medication meds) {
        return new ResponseEntity<>(this.patientService.getMedsByPatient(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/medications/{med_id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long med_id) {
        return new ResponseEntity<>(this.medService.destroyMeds(med_id), HttpStatus.OK);
    }

}
