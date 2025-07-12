package com.pm.patient_service.repository;

import com.pm.patient_service.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {

    boolean existsByEmail(String email);

    // check if user exist with the provided email,
    // but id should not be the one provided
    //means some other user is also having same email
    boolean existsByEmailIdNot(String email, UUID id);
}
