package com.g6.onlineeyecare.doctorServiceTest;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.g6.onlineeyecare.appointment.service.IAppointmentService;
import com.g6.onlineeyecare.doctor.dao.IDoctorRepository;
import com.g6.onlineeyecare.doctor.service.IDoctorService;
import com.g6.onlineeyecare.test.service.ITestService;

@Profile("test")
@Configuration
public class DoctorServiceTestConfiguration {

	@Bean
	@Primary
	public IDoctorService DoctorServiceTest() {
		return Mockito.mock(IDoctorService.class);
	}
	
	@Bean
	public IDoctorRepository f1() {
		return Mockito.mock(IDoctorRepository.class);
	}
	
	@Bean
	public IAppointmentService f2() {
		return Mockito.mock(IAppointmentService.class);
	}
	
	@Bean
	public ITestService f3() {
		return Mockito.mock(ITestService.class);
	}
}
