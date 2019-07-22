package dev.delenda.patient.controller;
import dev.delenda.patient.model.Medications;
import dev.delenda.patient.model.Patients;
import dev.delenda.patient.services.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")

public class PatientController {
    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    public ResponseEntity<Iterable<Patients>> getAllPatients() {
        return new ResponseEntity<>(patientService.getAllPatients(), HttpStatus.OK);
    }

    @GetMapping("/patients/{id}/medications")
    public ResponseEntity<Iterable<Medications>> patientMeds(@PathVariable Long id, @RequestBody Medications medications) {
        return new ResponseEntity<>(patientService.getPatientMeds(id), HttpStatus.OK);
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<Patients> getPatient(@PathVariable Long id) {
        return new ResponseEntity<>(patientService.getPatient(id), HttpStatus.OK);
    }

    @PostMapping("/patients")
    public ResponseEntity<Patients> newPatient(@RequestBody Patients patients) {
        return new ResponseEntity<>(patientService.newPatient(patients), HttpStatus.CREATED);
    }

    @PutMapping ("/patients/{id}")
    public ResponseEntity<Patients> updatePatient(@PathVariable Long id, @RequestBody Patients patient) {
        return new ResponseEntity<>(patientService.updatePatient(id, patient), HttpStatus.OK);
    }

    @DeleteMapping("/patients/{id}")
    public ResponseEntity<Boolean> destroyPatient(Long id) {
        return new ResponseEntity<>(patientService.destroy(id), HttpStatus.OK);
    }
}

