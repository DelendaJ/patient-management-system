package dev.delenda.patient.entities;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "medications")

public class Medication {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "med_id")
    private Long id;

    @Column(name = "medication_name")
    private String medicationName;
    @Column(name = "date_prescribed")
    private LocalDate datePrescribed;

    @ManyToOne
    @JsonIgnore
    private Patient patient;

    public void setPatient(Patient patients) {
        patients.getMedications().add(this);
    }

}
