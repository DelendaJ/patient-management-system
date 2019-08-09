package dev.delenda.patient.services;

import dev.delenda.patient.entities.Medications;
import dev.delenda.patient.entities.Patients;
import dev.delenda.patient.repositories.MedsRepo;
import dev.delenda.patient.repositories.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MedicationService {


    private MedsRepo medsRepo;
    private PatientRepo patientRepo;

    @Autowired
    public MedicationService(MedsRepo medsRepo, PatientRepo patientRepo) {
        this.medsRepo = medsRepo;
        this.patientRepo = patientRepo;
    }

    public Patients patientDrugs(Long id, Medications meds) {
        Patients patient = patientRepo.findById(id).get();
        patient.addMedications(meds);
        patientRepo.save(patient);
        return patient;
    }

    public Boolean destroyMeds(Long id) {
        medsRepo.deleteById(id);
        return true;
    }

}


