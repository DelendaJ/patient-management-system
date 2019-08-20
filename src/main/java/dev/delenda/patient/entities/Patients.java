package dev.delenda.patient.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.Years;


import javax.persistence.*;


import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patients")
@EqualsAndHashCode(exclude = "medications")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Patients {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @Column(name = "pat_id", columnDefinition = "BINARY(16)")
    private UUID id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    private int age;
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
        medications.add(meds);
        meds.setPatient(this);
    }


}

