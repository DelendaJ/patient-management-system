package dev.delenda.patient.services;


import dev.delenda.patient.entities.Medications;
import dev.delenda.patient.entities.Patients;
import dev.delenda.patient.repositories.PatientRepo;
import dev.delenda.patient.requestobject.PatientRequest;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


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

    public Patients getPatient(UUID id) {
        return patientRepo.findById(id).get();
    }

    public Patients newPatient(PatientRequest patient) {
        Patients newPatient = new Patients();
        String firstName = patient.getFirstName();
        String lastName = patient.getLastName();
        int age = patient.getPatientAge();
        String address = patient.getAddress();
        String phoneNumber = patient.getPhoneNumber();
        String socialSecurity = patient.getSocialSecurity();
        LocalDate dateOfBirth = patient.getDateOfBirth();

        newPatient.setFirstName(firstName);
        newPatient.setLastName(lastName);
        newPatient.setAge(age);
        newPatient.setAddress(address);
        newPatient.setPhoneNumber(phoneNumber);
        newPatient.setSocialSecurity(socialSecurity);
        newPatient.setDateOfBirth(dateOfBirth);
        return patientRepo.save(newPatient);

    }

    public Patients updatePatient(UUID id, PatientRequest patient) {
        Patients currentPatient = patientRepo.findById(id).get();
        String firstName = patient.getFirstName();
        String lastName = patient.getLastName();
        int age = patient.getPatientAge();
        String address = patient.getAddress();
        String phoneNumber = patient.getPhoneNumber();
        String socialSecurity = patient.getSocialSecurity();

        currentPatient.setFirstName(firstName);
        currentPatient.setLastName(lastName);
        currentPatient.setAge(age);
        currentPatient.setAddress(address);
        currentPatient.setPhoneNumber(phoneNumber);
        currentPatient.setSocialSecurity(socialSecurity);
        return patientRepo.save(currentPatient);
    }

    public Boolean destroy(UUID id) {
        patientRepo.deleteById(id);
        return true;
    }

    public Iterable<Medications> getMedsByPatient(UUID id) {
        if (!patientRepo.findById(id).isPresent()) {
            return null;
        }
        return patientRepo.findById(id).get().getMedications();
    }

}



