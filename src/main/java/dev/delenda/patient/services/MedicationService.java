package dev.delenda.patient.services;

import dev.delenda.patient.model.Medications;
import dev.delenda.patient.model.Patients;
import dev.delenda.patient.repositories.MedsRepo;
import dev.delenda.patient.repositories.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class MedicationService {

@Autowired
    private MedsRepo medsRepo;
@Autowired
    private PatientRepo patientRepo;


    public MedicationService(MedsRepo medsRepo) {
        this.medsRepo = medsRepo;

    }

    public Medications newMeds(Medications meds) {
        Medications medication = this.medsRepo.save(meds);
       return null;

    }

    public Patients patientDrugs(Long id, Patients patients) {
        Patients pat = patientRepo.findById(id).get();
        pat.setMedications(patients.getMedications());
        patientRepo.save(pat);
        return pat;
    }
/*
    Patients patients = patientRepo.findById(id).get();
        patients.setName(updatePatient.getName());
        patients.setAge(updatePatient.getAge());
        patients.setAddress(updatePatient.getAddress());
        patients.setPhoneNumber(updatePatient.getPhoneNumber());
        patients.setSocialSecurity(updatePatient.getSocialSecurity());
        patientRepo.save(patients);
        return patients;*/

      /*  Patients patients = patientRepo.findById(id).get();
        Medications medications = new Medications();
        medications.setPatient(meds.getPatient());
        patients.addMedications(medications);
        medsRepo.save(medications);
        return medications;*/


    public Boolean destroyMeds(Long id) {
        medsRepo.deleteById(id);
        return true;
    }

    private Set<Medications> saveMeds(Medications meds, Long id) {
        return null;

    }
}

