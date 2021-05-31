package com.cg.onlineeyecare.doctorServiceTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


import com.g6.onlineeyecare.appointment.service.IAppointmentService;
import com.g6.onlineeyecare.doctor.dao.IDoctorRepository;
import com.g6.onlineeyecare.doctor.dto.Doctor;
import com.g6.onlineeyecare.doctor.service.IDoctorService;
import com.g6.onlineeyecare.test.service.ITestService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class DoctorServiceTest {
	
	@Autowired
	IDoctorRepository repository;
	@Autowired
	IAppointmentService appointmentService;
	@Autowired
	ITestService testService;
	
	@Autowired
	@InjectMocks
	IDoctorService service;
	
	
	@Before
	public void init() {
		//service = new DoctorServiceImpl();
	}
	
	@Test
	public void f1() {
		Doctor d1 = new Doctor("11:30:00", 635241589, "abc@gmail.com", "bangalore");
		Doctor d2 = new Doctor("12:30:00", 786523496, "xyz@gmail.com", "mysore");
		
		List<Doctor> dummylist = new ArrayList<>();
		dummylist.add(d1);
		dummylist.add(d2);
		
		Mockito.when(repository.findAll()).thenReturn(dummylist);
		assertEquals(2, service.viewDoctorsList().size());
	}
}
