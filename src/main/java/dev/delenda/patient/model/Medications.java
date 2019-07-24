package dev.delenda.patient.model;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "medications")

public class Medications {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "med_id")
    private Long id;

    @Column(name = "medication_name")
    private String medicationName;
    @Column(name = "date_prescribed")
    private String datePrescribed;


    @ManyToOne
    @JsonIgnore
    private Patients patient;

public void setPatient(Patients pat) {
    this.patient = pat;
    if (!pat.getMedications().contains(this)) {
        pat.getMedications().add(this);
    }
}


}
