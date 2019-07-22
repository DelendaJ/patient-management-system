package dev.delenda.patient.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "patients")
public class Patients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;


    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;
    @Column(name = "address")
    private String address;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "social_security")
    private String socialSecurity;


    @OneToMany(cascade = {CascadeType.ALL})
    private Set<Medications> medications;

  public void addMedication(Medications meds) {
      medications.add(meds);
      meds.setPatient(this);
  }
}


