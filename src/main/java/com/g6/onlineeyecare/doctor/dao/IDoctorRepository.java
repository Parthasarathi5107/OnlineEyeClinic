package com.g6.onlineeyecare.doctor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g6.onlineeyecare.doctor.dto.Doctor;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, Integer>{
	
}
