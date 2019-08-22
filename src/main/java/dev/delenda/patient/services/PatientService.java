package dev.delenda.patient.services;


import dev.delenda.patient.entities.Medications;
import dev.delenda.patient.entities.Patients;
import dev.delenda.patient.repositories.PatientRepo;
import dev.delenda.patient.requestobject.PatientRequest;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
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
        String socialSecurity = patient.getSocialSecurity();
        LocalDate dateOfBirth = patient.getDateOfBirth();
        Set<Medications> meds = patient.getMedications();

        newPatient.setFirstName(firstName);
        newPatient.setLastName(lastName);
        newPatient.setSocialSecurity(socialSecurity);
        newPatient.setDateOfBirth(dateOfBirth);
        newPatient.setMedications(meds);
        return patientRepo.save(newPatient);

    }

    public Patients updatePatient(UUID id, PatientRequest patient) {
        Patients currentPatient = patientRepo.findById(id).get();
        String firstName = patient.getFirstName();
        String lastName = patient.getLastName();
        String socialSecurity = patient.getSocialSecurity();
        Set<Medications> meds = patient.getMedications();

        currentPatient.setFirstName(firstName);
        currentPatient.setLastName(lastName);
        currentPatient.setSocialSecurity(socialSecurity);
        currentPatient.setMedications(meds);
        return patientRepo.save(currentPatient);
    }

    public Boolean destroy(UUID id) {
        patientRepo.deleteById(id);
        return true;
    }

    public Set<Medications> getMedsByPatient(UUID id) {
        if (!patientRepo.findById(id).isPresent()) {
            return null;
        }
        return patientRepo.findById(id).get().getMedications();
    }

}



