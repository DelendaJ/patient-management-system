package dev.delenda.patient.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;



import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "medications")

public class Medications {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;
    @Column(name = "medication_name")
    private String medicationName;
    @Column(name = "date_prescribed")
    private String datePrescribed;


    @ManyToOne (fetch = FetchType.EAGER)
    @JsonIgnore
    private Patients patient;

}
