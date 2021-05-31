package com.g6.onlineeyecare.patient.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g6.onlineeyecare.patient.dto.Patient;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Integer>{
	
}
