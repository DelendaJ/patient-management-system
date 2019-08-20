package dev.delenda.patient.requestobject;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.joda.time.LocalDate;
import org.joda.time.Years;

import java.util.UUID;

@Data
@AllArgsConstructor
public class PatientRequest {

    private UUID id;
    private String firstName;
    private String lastName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "EST")
    private LocalDate dateOfBirth;
    private int age;
    private String address;
    private String phoneNumber;
    private String socialSecurity;


    public int getPatientAge() {
        LocalDate now = LocalDate.now();
        Years age = Years.yearsBetween(dateOfBirth, now);
        return age.getYears();

    }
}

