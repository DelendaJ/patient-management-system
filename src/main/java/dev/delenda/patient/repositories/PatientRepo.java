package dev.delenda.patient.repositories;

import dev.delenda.patient.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface PatientRepo extends JpaRepository<Patient, UUID> {



}
