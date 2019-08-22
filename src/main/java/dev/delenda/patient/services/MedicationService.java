package dev.delenda.patient.services;

import dev.delenda.patient.entities.Medication;
import dev.delenda.patient.entities.Patient;
import dev.delenda.patient.repositories.MedsRepo;
import dev.delenda.patient.repositories.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class MedicationService {


    private MedsRepo medsRepo;
    private PatientRepo patientRepo;

    @Autowired
    public MedicationService(MedsRepo medsRepo, PatientRepo patientRepo) {
        this.medsRepo = medsRepo;
        this.patientRepo = patientRepo;
    }

    public Patient patientDrugs(UUID id, Medication meds) {
        Patient patient = patientRepo.findById(id).get();
        patient.addMedications(meds);
        patientRepo.save(patient);
        return patient;
    }

    public Boolean destroyMeds(Long id) {
        medsRepo.deleteById(id);
        return true;
    }

}


