package dev.delenda.patient.services;


import dev.delenda.patient.model.Medications;
import dev.delenda.patient.model.Patients;
import dev.delenda.patient.repositories.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;



@Service
public class PatientService {

    private PatientRepo patientRepo;

    @Autowired
    public PatientService(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }

    public Iterable<Patients> getAllPatients() {
        return patientRepo.findAll();
    }

   // public Patients findByName(String name) {
      //  return patientRepo.findByName(name).get();
  //  }

    public Patients getPatient(Long id) {
        return patientRepo.findById(id).get();
    }

    public Patients newPatient(Patients patient) {
        return patientRepo.save(patient);
    }

    public Patients updatePatient(Long id, Patients updatePatient) {
        Patients patients = patientRepo.findById(id).get();
        patients.setName(updatePatient.getName());
        patients.setAge(updatePatient.getAge());
        patients.setAddress(updatePatient.getAddress());
        patients.setPhoneNumber(updatePatient.getPhoneNumber());
        patients.setSocialSecurity(updatePatient.getSocialSecurity());
        patientRepo.save(patients);
        return patients;
    }

    public Boolean destroy(Long id) {
        patientRepo.deleteById(id);
        return true;
    }

   // public Iterable<Medications> getPatientMeds(Long id) {
      //  return patientRepo.findById(id).get().getMedications();
    //}

    public Iterable<Medications> getMedsByPatient(Long id) {
        if (!patientRepo.findById(id).isPresent()) {
            return null;
        }
        return patientRepo.findById(id).get().getMedications();
    }

    /*public Patients addMedsToPatient(Long id, Medications meds) {
        Optional<Patients> patient = patientRepo.findById(id);
        patient.ifPresent(record -> {
            record.addMedications(new Medications(meds));
            patientRepo.save(record));
            return record;
        }*/



    }



