package dev.delenda.patient.repositories;


import dev.delenda.patient.entities.Medication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MedsRepo extends JpaRepository<Medication, Long> {



}
