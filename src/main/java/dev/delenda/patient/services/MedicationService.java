package dev.delenda.patient.services;

import dev.delenda.patient.model.Medications;
import dev.delenda.patient.model.Patients;
import dev.delenda.patient.repositories.MedsRepo;
import dev.delenda.patient.repositories.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Set;


@Service
public class MedicationService {

   
    private MedsRepo medsRepo;
    private PatientRepo patientRepo;

 @Autowired
    public MedicationService(MedsRepo medsRepo) {
        this.medsRepo = medsRepo;

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


