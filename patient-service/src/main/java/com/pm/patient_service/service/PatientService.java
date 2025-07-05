package com.pm.patient_service.service;

import com.pm.patient_service.dto.PatientRequestDTO;
import com.pm.patient_service.dto.PatientResponseDTO;
import com.pm.patient_service.mapper.PatientMapper;
import com.pm.patient_service.model.Patient;
import com.pm.patient_service.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {



    @Autowired
    PatientRepository patientRepository;


    public List<PatientResponseDTO> getPatients(){

        List<Patient> patients = patientRepository.findAll();

        List<PatientResponseDTO> patientResponseDTOS = patients.stream().map(PatientMapper::toDTO).toList();

        return patientResponseDTOS;

    }


    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO){

        Patient patient = PatientMapper.toModel(patientRequestDTO);
        Patient newPatient = patientRepository.save(patient);//in hibernate it used to return only id, primary key, not whole entity

        return PatientMapper.toDTO(patient);

    }

}
