package com.g6.onlineeyecare.spectacleservicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.g6.onlineeyecare.exceptions.PatientIdFoundNotException;
import com.g6.onlineeyecare.exceptions.SpectaclesIdNotFoundException;
import com.g6.onlineeyecare.patient.dao.IPatientRepository;
import com.g6.onlineeyecare.patient.dto.Patient;
import com.g6.onlineeyecare.patient.service.IPatientService;
import com.g6.onlineeyecare.patient.service.PatientServiceImpl;
import com.g6.onlineeyecare.spectacles.dao.ISpectaclesRepository;
import com.g6.onlineeyecare.spectacles.dto.Spectacles;
import com.g6.onlineeyecare.spectacles.service.SpectaclesServiceImpl;

@SpringBootTest
public class SpectaclesServiceTest {

	ISpectaclesRepository repository;
	IPatientRepository patientRepository;

	@InjectMocks
	static SpectaclesServiceImpl spectaclesService;
	static IPatientService patientService;

	private static AutoCloseable ac;

	@Before
	public void doinit() {

		repository = mock(ISpectaclesRepository.class);
		patientRepository = mock(IPatientRepository.class);

		spectaclesService = new SpectaclesServiceImpl(repository);
		patientService = new PatientServiceImpl(patientRepository);

		ac = MockitoAnnotations.openMocks(this);
	}

	@AfterEach
	public void doAtEnd() throws Exception {
		ac.close();
	}

	@Test
	@DisplayName("test -> to view all spectacles")
	public void testViewAllSpectacles() {
		Patient p=new Patient(20,"259751","ram@gmail.com",LocalDate.of(2002,02,12), "Bangalore");
		p.setUserId(1);

	     Spectacles s=new Spectacles(1,"A-254","rectangle glasses", 3000,p);

		List<Spectacles> list = new ArrayList<Spectacles>();
		list.add(s);

		when(repository.findAll()).thenReturn(list);

		List<Spectacles> actualList = spectaclesService.viewSpectacles();

		verify(repository).findAll();
		assertEquals(list, actualList);
	}

	@Test
	@DisplayName("test -> to view spectacles by Id")
	public void testViewById() throws SpectaclesIdNotFoundException {

		Patient p=new Patient(20,"259751","ram@gmail.com",LocalDate.of(2002,02,12), "Bangalore");
		p.setUserId(1);

		Spectacles s=new Spectacles(1,"A-254","rectangle glasses", 3000,p);

		when(repository.findById(1)).thenReturn(Optional.of(s));
		Spectacles actualSpectacles = spectaclesService.viewSpectacles(1);
		verify(repository).findById(1);
		assertEquals(s, actualSpectacles);

	}
	

	@Test
	@DisplayName("test -> to view spectacles by Id with invalid entries")
	public void testViewByIdInvalid() throws SpectaclesIdNotFoundException {

		Patient p=new Patient(20,"259751","ram@gmail.com",LocalDate.of(2002,02,12), "Bangalore");
		p.setUserId(1);

		Spectacles s=new Spectacles(1,"A-254","rectangle glasses", 3000,p);

		when(repository.findById(1)).thenReturn(Optional.of(s));
		Executable executable = () -> spectaclesService.viewSpectacles(2);
		assertThrows(SpectaclesIdNotFoundException.class, executable);

	}

	@Test
	@DisplayName("test -> to add spectacles with valid entries ")
	public void testAddSpectacles() throws PatientIdFoundNotException {
		Patient p=new Patient(20,"259751","ram@gmail.com",LocalDate.of(2002,02,12),"Bangalore");
		p.setUserId(1);

		when(patientRepository.findById(p.getUserId())).thenReturn(Optional.of(p));

		Spectacles s=new Spectacles(1,"A-254","rectangle glasses", 3000,p);

		when(repository.save(s)).thenReturn(s);
		Spectacles actualSpectacles = spectaclesService.addSpectacles(s);
		verify(repository).save(s);
		assertEquals(s, actualSpectacles);
	}

	@Test
	@DisplayName("test -> to add spectacles with invalid entries")
	public void testAddSpectaclesInvalidEntries() throws PatientIdFoundNotException {

		

		Patient p1 = mock(Patient.class);
		Spectacles s=new Spectacles(1,"A-254","rectangle glasses", 3000,p1);
		

		when(repository.save(s)).thenReturn(s);
		Executable executable = () -> spectaclesService.addSpectacles(s);
		assertThrows(PatientIdFoundNotException.class, executable);

	}

	@Test
	@DisplayName("test -> to delete spectacles by valid Id")
	public void testDeleteSpectacles() throws SpectaclesIdNotFoundException {

		Patient p1 = new Patient(20, "259751", "ram@gmail.com", LocalDate.of(2002, 02, 12), "Bangalore");
		p1.setUserId(1);

		Spectacles s=new Spectacles(1,"A-254","rectangle glasses", 3000,p1);
		when(repository.findById(1)).thenReturn(Optional.of(s));
		Spectacles spec = spectaclesService.removeSpectacles(1);
		verify(repository).deleteById(1);
		assertEquals(spec , s);
	}
	
	@Test
	@DisplayName("test -> to delete spectacles with invalid entries")
	public void testDeleteSpectaclesInvalid() throws SpectaclesIdNotFoundException {

		Patient p1 = mock(Patient.class);

		Spectacles s=new Spectacles(1,"A-254","rectangle glasses", 3000,p1);
		when(repository.findById(1)).thenReturn(Optional.of(s));
		Executable executable = () -> spectaclesService.removeSpectacles(2);
		assertThrows(SpectaclesIdNotFoundException.class, executable);
	}
	
	@Test
	@DisplayName("test -> to update spectacles with valid entries")
	public void testUpdateSpectacles() throws SpectaclesIdNotFoundException
	{
		Patient p1 = new Patient(20, "259751", "ram@gmail.com", LocalDate.of(2002, 02, 12), "Bangalore");
		p1.setUserId(1);

		Spectacles s=new Spectacles(1,"A-254","rectangle glasses", 3000,p1);
		when(repository.findById(1)).thenReturn(Optional.of(s));
		Spectacles spec = spectaclesService.updateSpectacles(s);
		verify(repository).save(s);
		assertEquals(spec , s);
	}

	@Test
	@DisplayName("test -> to update spectacles with invalid entries")
	public void testUpdateSpectaclesInvalid() throws SpectaclesIdNotFoundException
	{
		Patient p1 = new Patient(20, "259751", "ram@gmail.com", LocalDate.of(2002, 02, 12), "Bangalore");
		p1.setUserId(1);

		Spectacles s=new Spectacles(1,"A-254","rectangle glasses", 3000,p1);
		when(repository.findById(10)).thenReturn(Optional.of(s));
		Executable executable = () -> spectaclesService.updateSpectacles(s);
		assertThrows(SpectaclesIdNotFoundException.class, executable);
	}
}
