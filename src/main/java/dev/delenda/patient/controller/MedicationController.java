package dev.delenda.patient.controller;

import dev.delenda.patient.model.Medications;
import dev.delenda.patient.model.Patients;
import dev.delenda.patient.services.MedicationService;
import dev.delenda.patient.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/patients")
@CrossOrigin("*")
public class MedicationController {

    @Autowired
    private MedicationService medService;
    @Autowired
    private PatientService patientService;


    public MedicationController(MedicationService medService) {
        this.medService = medService;
    }

    @PostMapping("/{id}/medications")
    public ResponseEntity<Patients> addNewMedsToPatient(@PathVariable Long id, @RequestBody Medications meds) {
        return new ResponseEntity<>(this.medService.patientDrugs(id, meds), HttpStatus.CREATED);
    }

    @GetMapping("/{id}/medications")
    public ResponseEntity<Iterable<Medications>> patientMeds(@PathVariable Long id, @RequestBody Medications medications) {
        return new ResponseEntity<>(this.patientService.getMedsByPatient(id), HttpStatus.OK);
    }


//        return new ResponseEntity<>(medService.newMeds(medication), HttpStatus.CREATED);
//    }

    @DeleteMapping("/{id}/medications/{med_id}")
    public ResponseEntity<Boolean> destroy(Long id) {
        return new ResponseEntity<>(medService.destroyMeds(id), HttpStatus.OK);
    }



}
