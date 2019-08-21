package dev.delenda.patient.requestobject;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.delenda.patient.entities.Medications;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.joda.time.LocalDate;
import org.joda.time.Years;

import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
public class PatientRequest {

    private UUID id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private int age;
    private String address;
    private String phoneNumber;
    private String socialSecurity;
    private Set<Medications> medications;

    public int getPatientAge() {
        LocalDate now = LocalDate.now();
        Years age = Years.yearsBetween(dateOfBirth, now);
        return age.getYears();

    }

}

