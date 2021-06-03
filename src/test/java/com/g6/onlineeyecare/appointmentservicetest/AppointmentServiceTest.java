package com.g6.onlineeyecare.appointmentservicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.g6.onlineeyecare.appointment.dao.IAppointmentRepository;
import com.g6.onlineeyecare.appointment.dto.Appointment;
import com.g6.onlineeyecare.appointment.service.AppointmentServiceImpl;
import com.g6.onlineeyecare.doctor.dao.IDoctorRepository;
import com.g6.onlineeyecare.doctor.dto.Doctor;
import com.g6.onlineeyecare.doctor.service.DoctorServiceImpl;
import com.g6.onlineeyecare.doctor.service.IDoctorService;
import com.g6.onlineeyecare.exceptions.AppointmentIdNotFoundException;
import com.g6.onlineeyecare.exceptions.DoctorIdNotFoundException;
import com.g6.onlineeyecare.exceptions.PatientIdFoundNotException;
import com.g6.onlineeyecare.patient.dao.IPatientRepository;
import com.g6.onlineeyecare.patient.dto.Patient;
import com.g6.onlineeyecare.patient.service.IPatientService;
import com.g6.onlineeyecare.patient.service.PatientServiceImpl;

@SpringBootTest
public class AppointmentServiceTest {

	IAppointmentRepository repository;
	IPatientRepository patientRepository;
	IDoctorRepository doctorRepository;

	@InjectMocks
	static AppointmentServiceImpl appointmentService;
	static IDoctorService doctorService;
	static IPatientService patientService;
	private static AutoCloseable ac;

	@Before
	public void doinit() {
		repository = mock(IAppointmentRepository.class);
		patientRepository = mock(IPatientRepository.class);
		doctorRepository = mock(IDoctorRepository.class);

		appointmentService = new AppointmentServiceImpl(repository);
		doctorService = new DoctorServiceImpl(doctorRepository);
		patientService = new PatientServiceImpl(patientRepository);

		ac = MockitoAnnotations.openMocks(this);
	}

	@AfterEach
	public void doAtEnd() throws Exception {
		ac.close();
	}

	@Test
	@DisplayName("test -> view all appointments")
	public void testViewAllAppointments() {
		Appointment appointment = new Appointment();
		appointment.setAppointmentId(1);
		List<Appointment> list = new ArrayList<Appointment>();
		list.add(appointment);

		when(repository.findAll()).thenReturn(list);
		List<Appointment> actualList = appointmentService.viewAllAppointments();
		verify(repository).findAll();
		assertEquals(list, actualList);
	}

	@Test
	@DisplayName("test -> for view by Id for valid credentials")
	public void testViewById() throws AppointmentIdNotFoundException {

		Appointment appointment = new Appointment();
		appointment.setAppointmentId(1);

		when(repository.findById(1)).thenReturn(Optional.of(appointment));
		Appointment a = appointmentService.viewAppointment(1);
		verify(repository).findById(appointment.getAppointmentId());
		assertEquals(a, appointment);
	}

	@Test(expected = AppointmentIdNotFoundException.class)
	@DisplayName("test -> for view by Id for invalid credentials")
	public void testViewByIdforInvalidEntries() throws AppointmentIdNotFoundException {

		Appointment appointment = new Appointment();
		appointment.setAppointmentId(1);

		when(repository.findById(1)).thenReturn(Optional.of(appointment));
		Appointment actualAppointment = appointmentService.viewAppointment(2);
		verify(repository).findById(appointment.getAppointmentId());

	}

	@Test
	@DisplayName("test -> for booking an appointment with valid entries")
	public void testBookAppointment() throws DoctorIdNotFoundException, PatientIdFoundNotException {
		Patient p = new Patient();
		p.setUserId(1);

		Patient p1 = new Patient();
		p1.setUserId(1);
		when(patientRepository.findById(p.getUserId())).thenReturn(Optional.of(p1));

		Doctor d = new Doctor();
		d.setUserId(5);

		Doctor d1 = new Doctor();
		d1.setUserId(5);

		when(doctorRepository.findById(d.getUserId())).thenReturn(Optional.of(d1));

		Appointment appointment = new Appointment(10, LocalDate.now(), LocalTime.now(), d1, p1);
		Appointment ExcepectAppointment = new Appointment(10, LocalDate.now(), LocalTime.now(), d1, p1);

		when(repository.save(appointment)).thenReturn(ExcepectAppointment);

		Appointment actualAppointment = appointmentService.bookAppointment(appointment);

		assertEquals(ExcepectAppointment, actualAppointment);

		verify(repository).save(appointment);

	}

	@Test(expected = DoctorIdNotFoundException.class)
	@DisplayName("test -> for booking an appointment with invalid entries")
	public void testBookAppointmentInvalidEntries() throws DoctorIdNotFoundException, PatientIdFoundNotException {
		Patient p = mock(Patient.class);
		Doctor d = mock(Doctor.class);
		Appointment appointment = new Appointment(10, LocalDate.now(), LocalTime.now(), d, p);
		Appointment ExcepectAppointment = new Appointment(10, LocalDate.now(), LocalTime.now(), d, p);

		when(repository.save(appointment)).thenReturn(ExcepectAppointment);
		Appointment actualAppointment = appointmentService.bookAppointment(appointment);
		verify(repository).save(appointment);

	}

	@Test
	@DisplayName("test -> for deleting appointment")
	public void testDeleteAppointment() throws AppointmentIdNotFoundException {
		Appointment appointment = new Appointment();
		appointment.setAppointmentId(1);

		when(repository.findById(1)).thenReturn(Optional.of(appointment));
		Appointment actualAppointment = appointmentService.cancelAppointment(1);
		verify(repository).deleteById(1);
		assertEquals(appointment, actualAppointment);

	}

}