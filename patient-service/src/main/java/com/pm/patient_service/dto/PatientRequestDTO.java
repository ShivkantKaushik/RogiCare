package com.pm.patient_service.dto;

import com.pm.patient_service.dto.validators.CreatePatientValidationGroup;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PatientRequestDTO {

    @NotBlank(message = "Name cannot be empty")
    @Size(max = 100, message = "Name must be smaller than 100 characters.")
    private String name;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email is not valid.")
    private String email;

    @NotBlank(message = "Address cannot be empty")
    private String address;

    @NotBlank(message = "DOB cannot be empty")
    private String dateOfBirth;


    @NotBlank( groups = {CreatePatientValidationGroup.class}, message = "Registered date cannot be empty")
    private String registeredDate;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }
}
