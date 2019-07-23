package dev.delenda.patient.services;

import dev.delenda.patient.model.Medications;
import dev.delenda.patient.repositories.MedsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MedicationService {
    private MedsRepo medsRepo;


    @Autowired
    public MedicationService(MedsRepo medsRepo) {
        this.medsRepo = medsRepo;

    }

    public Medications newMeds(Medications meds) {
        return medsRepo.save(meds);
    }

    public Boolean destroyMeds(Long id) {
        medsRepo.deleteById(id);
        return true;
    }


}
