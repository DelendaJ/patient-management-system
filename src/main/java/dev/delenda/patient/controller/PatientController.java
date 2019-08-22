package dev.delenda.patient.controller;

import dev.delenda.patient.entities.Patient;
import dev.delenda.patient.requestobject.PatientRequest;
import dev.delenda.patient.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/api")


public class PatientController {

    private PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    public ResponseEntity<Iterable<Patient>> getAllPatients() {
        return new ResponseEntity<>(patientService.getAllPatients(), HttpStatus.OK);
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable UUID id) {
        return new ResponseEntity<>(patientService.getPatient(id), HttpStatus.OK);
    }

    @PostMapping("/patients")
    public ResponseEntity<Patient> newPatient(@RequestBody PatientRequest patients) {
        return new ResponseEntity<>(patientService.newPatient(patients), HttpStatus.CREATED);
    }

    @PutMapping("/patients/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable UUID id, @RequestBody PatientRequest patient) {
        return new ResponseEntity<>(patientService.updatePatient(id, patient), HttpStatus.OK);
    }

    @DeleteMapping("/patients/{id}")
    public ResponseEntity<Boolean> destroyPatient(@PathVariable UUID id) {
        return new ResponseEntity<>(patientService.destroy(id), HttpStatus.OK);
    }
}
