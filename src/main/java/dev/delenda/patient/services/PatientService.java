package dev.delenda.patient.services;


import dev.delenda.patient.entities.Medications;
import dev.delenda.patient.entities.Patients;
import dev.delenda.patient.repositories.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
        //patients.setMedications(updatePatient.getMedications());
        patientRepo.save(patients);
        return patients;
    }

    public Boolean destroy(Long id) {
        patientRepo.deleteById(id);
        return true;
    }

    public Iterable<Medications> getMedsByPatient(Long id) {
        if (!patientRepo.findById(id).isPresent()) {
            return null;
        }
        return patientRepo.findById(id).get().getMedications();
    }

}



