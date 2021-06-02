package com.g6.onlineeyecare.testservicetest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.g6.onlineeyecare.test.dto.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.g6.onlineeyecare.exceptions.PatientIdFoundNotException;
import com.g6.onlineeyecare.exceptions.TestIdNotFoundException;
import com.g6.onlineeyecare.patient.dao.IPatientRepository;
import com.g6.onlineeyecare.patient.dto.Patient;
import com.g6.onlineeyecare.patient.service.IPatientService;
import com.g6.onlineeyecare.patient.service.PatientServiceImpl;
import com.g6.onlineeyecare.test.dao.ITestRepository;
import com.g6.onlineeyecare.test.service.TestServiceImpl;

@SpringBootTest
public class TestServiceTest {

	ITestRepository repository;
	IPatientRepository patientRepository;
	
	
	@InjectMocks
	static TestServiceImpl testService;
	static IPatientService patientService;
	private static AutoCloseable ac;
	
	 
	@Before
	public void doinit() {
		repository = mock(ITestRepository.class);
		patientRepository = mock(IPatientRepository.class);
		
		
		testService = new TestServiceImpl(repository);
		patientService = new PatientServiceImpl(patientRepository);
		
		
		ac = MockitoAnnotations.openMocks(this);
	}
	
	@AfterEach
	public void doAtEnd()throws Exception
	{
		ac.close();
	}
	
	@org.junit.Test
	@DisplayName("view all test")
	public void ViewAllTest() {
		
		Patient p=new Patient(20,259751,"ram@gmail.com",LocalDate.of(2002,02,12), "Bangalore");
		Test test=new Test(1, "abc", "vision","describe",1800,p);
		
		List<Test> list=new ArrayList<>();
		list.add(test);
		
		when(repository.findAll()).thenReturn(list);
		List<Test> output = testService.viewAllTests();
		
		verify(repository).findAll();
		assertIterableEquals(list, output);
		verify(repository).findAll();
	}
	
	@org.junit.Test
   
	@DisplayName("test -> view test by testId")
    public void testViewTestById() throws TestIdNotFoundException{

        Test t=new Test();
        t.setTestId(1);
        Optional<Test> s = Optional.of(t);

        when(repository.findById(1)).thenReturn(s);
        Test test=testService.viewTest(1);
        assertEquals(test, t);
        verify(repository).findById(1);
    }

	@org.junit.Test
	@DisplayName("test -> adding a  test with valid entries")
	public void addTest() throws PatientIdFoundNotException   {
		
		Patient p=new Patient(20,259751,"ram@gmail.com",LocalDate.of(2002,02,12), "Bangalore");
		p.setUserId(1);
		
		Patient p1=new Patient(20,259751,"ram@gmail.com",LocalDate.of(2002,02,12), "Bangalore");
		p1.setUserId(1);
		 Optional<Patient> expectedP = Optional.of(p1);
		when(patientRepository.findById(p.getUserId())).thenReturn(expectedP);
		
		Test test=new Test(2, "abc", "vision","describe",1800,expectedP.get());
		Test testExpected=new Test(2, "abc", "vision","describe",1800,expectedP.get());
		
		
		when(repository.save(test)).thenReturn(testExpected);
		
		Test actucalTest =  testService.addTest(test);
		assertNotNull(actucalTest);
		assertEquals(testExpected, actucalTest);
		verify(repository).save(test);		
	}
	
	@org.junit.Test(expected = PatientIdFoundNotException.class)
	@DisplayName("test -> adding a  test with invalid entries")
	public void addTestInvalidEntries() throws PatientIdFoundNotException   {
		

		
		Patient p = mock(Patient.class);
		Test test=new Test(2, "abc", "vision","describe",1800,p);
		Test testExpected=new Test(2, "abc", "vision","describe",1800,p);
		
		when(repository.save(test)).thenReturn(testExpected);
		Test actucalTest =  testService.addTest(test);
		assertNotNull(actucalTest);
		verify(repository).save(test);		
	}
	
	
	@org.junit.Test
	@DisplayName("test -> delete a test with valid entries")
    public void deleteTest() throws TestIdNotFoundException
    {
        Patient p=new Patient(20,259751,"ram@gmail.com",LocalDate.of(2002,02,12), "Bangalore");
        Test test=new Test();
        test.setTestId(1);

        when(repository.findById(test.getTestId())).thenReturn(Optional.of(test));

            testService.removeTest(test.getTestId());
            verify(repository).deleteById(test.getTestId());


    }
	
	@org.junit.Test(expected = TestIdNotFoundException.class)
	@DisplayName("test -> delete a test with invalid entries")
    public void deleteTestIdException() throws TestIdNotFoundException
    {
        Test test=new Test();
        test.setTestId(1);
        when(repository.findById(1)).thenReturn(Optional.of(test));
        testService.removeTest(3);
        verify(repository).findById(3);


    }
	
}

