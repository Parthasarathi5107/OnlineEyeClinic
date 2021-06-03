package com.g6.onlineeyecare.reportservicetest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import com.g6.onlineeyecare.test.dto.Test;
import com.g6.onlineeyecare.exceptions.PatientIdFoundNotException;
import com.g6.onlineeyecare.exceptions.ReportIdNotFoundException;
import com.g6.onlineeyecare.exceptions.TestIdNotFoundException;
import com.g6.onlineeyecare.patient.dao.IPatientRepository;
import com.g6.onlineeyecare.patient.dto.Patient;
import com.g6.onlineeyecare.patient.service.IPatientService;
import com.g6.onlineeyecare.patient.service.PatientServiceImpl;
import com.g6.onlineeyecare.report.dao.IReportRepository;
import com.g6.onlineeyecare.report.dto.Report;
import com.g6.onlineeyecare.report.service.ReportServiceImpl;
import com.g6.onlineeyecare.spectacles.dao.ISpectaclesRepository;
import com.g6.onlineeyecare.spectacles.service.ISpectaclesService;
import com.g6.onlineeyecare.spectacles.service.SpectaclesServiceImpl;
import com.g6.onlineeyecare.test.dao.ITestRepository;
import com.g6.onlineeyecare.test.service.ITestService;
import com.g6.onlineeyecare.test.service.TestServiceImpl;

@SpringBootTest
public class ReportServiceTest {

	IReportRepository repository;
	IPatientRepository patientRepository;
	ITestRepository testRepository;
	ISpectaclesRepository spectaclesRepository;

	@InjectMocks
	static ReportServiceImpl reportService;
	static ISpectaclesService spectacleService;
	static IPatientService patientService;
	static ITestService testService;
	private static AutoCloseable ac;

	@Before
	public void doinit() {
		repository = mock(IReportRepository.class);
		patientRepository = mock(IPatientRepository.class);
		testRepository = mock(ITestRepository.class);
		spectaclesRepository = mock(ISpectaclesRepository.class);

		reportService = new ReportServiceImpl(repository);
		spectacleService = new SpectaclesServiceImpl(spectaclesRepository);
		patientService = new PatientServiceImpl(patientRepository);
		testService = new TestServiceImpl(testRepository);

		ac = MockitoAnnotations.openMocks(this);
	}

	@AfterEach
	public void doAtEnd() throws Exception {
		ac.close();
	}

//	@org.junit.Test
//	@DisplayName("test -> view all report")
//	public void viewAllReport() {
//		
//		Patient p1=new Patient(20,259751,"ram@gmail.com",LocalDate.of(2002,02,12), "Bangalore");
//		p1.setUserId(1);
//		
//		Test test=new Test(2, "abc", "vision","describe",1800,p1);
//
//		
//		Report r = new Report(1, LocalDate.of(2002,02,12), "report description", "visualacuity", "visualacuitynear", "visualacuitydistance", test, p1);
//		Report r1 = new Report(2, LocalDate.of(2003,02,12), "report description", "visualacuity", "visualacuitynear", "visualacuitydistance", test, p1);
//		
//		List<Report> dummylist = new ArrayList<>();
//		dummylist.add(r);
//		dummylist.add(r1);
//		
//		when(repository.findAll()).thenReturn(dummylist);
//		List<Report> output = reportService.viewAllReport(LocalDate.of(2002,02,12));
//		
//		verify(repository).viewReportByDate(LocalDate.of(2002,02,12));
//		assertEquals(1, output.size());
//	}

	@org.junit.Test
	@DisplayName("test -> add a report")
	public void addReport() throws TestIdNotFoundException, PatientIdFoundNotException {

		Patient p = new Patient();
		p.setUserId(1);
		when(patientRepository.findById(1)).thenReturn(Optional.of(p));
		Test t = new Test();
		t.setTestId(2);
		when(testRepository.findById(2)).thenReturn(Optional.of(t));

		Report r = new Report( LocalDate.of(2002, 02, 12), "report description", "visualacuity", "visualacuitynear",
				"visualacuitydistance", t, p);
		Report expectedR = new Report( LocalDate.of(2002, 02, 12), "report description", "visualacuity",
				"visualacuitynear", "visualacuitydistance", t, p);

		when(repository.save(r)).thenReturn(expectedR);
		Report actualR = reportService.addReport(r);
		verify(repository).save(r);
		assertEquals(expectedR, actualR);
	}

//	@org.junit.Test
//	@DisplayName("view report using reportId and patientId")
//	public void viewReportById() throws ReportIdNotFoundException, PatientIdFoundNotException {
//
////		Patient p = new Patient();
////		p.setUserId(1);
////
////		Test t = new Test();
////		t.setTestId(2);
//
//		Report r = new Report(3, LocalDate.of(2002, 02, 12), "report description", "visualacuity", "visualacuitynear",
//				"visualacuitydistance", t, p);
//		when(patientRepository.findById(1)).thenReturn(Optional.of(p));
//		when(repository.findById(3)).thenReturn(Optional.of(r));
//		Report r1 = reportService.viewReport(3, 1);
//		System.out.println(r1);
//		 assertNotEquals(r, r1);
//		// assertEquals(r, r1);
//		verify(repository).findReportByPatiendIdandReportId(3, 1);
//
//	}
	
	@org.junit.Test
	public void viewReportById() {
		
		Patient expectedPatient = new Patient(1, "abc", "Partha", "patient");
		Test expectedTest = new Test(3, "eyetest", "type", "description", 2000, expectedPatient);
		Report expectedReport = new Report(LocalDate.of(2021, 6, 3), "description", "visual acuity", "viscual acuity near", "distance", expectedTest, expectedPatient);
		
		when(patientRepository.findById(1)).thenReturn(Optional.of(expectedPatient));
		when(repository.findById(2)).thenReturn(Optional.of(expectedReport));
		Report actualReport = null;
		try {
			actualReport = reportService.viewReport(2, 1);
		} catch (ReportIdNotFoundException e) {
			e.printStackTrace();
		} catch (PatientIdFoundNotException e) {
			
			e.printStackTrace();
		}
		assertNotNull(actualReport);
		assertEquals(expectedReport.getReportId(), actualReport.getReportId());
	}

	@org.junit.Test
	@DisplayName("test -> delete a report")
	public void deleteReport() throws ReportIdNotFoundException {

		Patient p1 = new Patient();
		Test test = new Test();

		Report r = new Report(LocalDate.of(2002, 02, 12), "report description", "visualacuity", "visualacuitynear",
				"visualacuitydistance", test, p1);
		when(repository.findById(1)).thenReturn(Optional.of(r));
		Report actualR = reportService.removeReport(1);
		verify(repository).findById(1);
		assertEquals(r, actualR);
	}

}
