package dev.delenda.patient.requestobject;

import dev.delenda.patient.entities.Medications;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.joda.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
public class PatientRequest {

    private UUID id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String address;
    private String phoneNumber;
    private String socialSecurity;
    private Set<Medications> medications;


}

