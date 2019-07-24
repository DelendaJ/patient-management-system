package dev.delenda.patient.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patients")
public class Patients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pat_id")
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


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "pat_id", referencedColumnName = "pat_id")
    private Set<Medications> medications = new HashSet<>();

    public void addMedications(Medications meds) {
        this.medications.add(meds);
        if (meds.getPatient() != this) {
            meds.setPatient(this);
        }
    }


}

