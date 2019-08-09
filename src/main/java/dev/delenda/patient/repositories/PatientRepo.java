package dev.delenda.patient.repositories;

import dev.delenda.patient.entities.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PatientRepo extends JpaRepository<Patients, Long> {
    //Optional<Patients> findByName(String name);


}
