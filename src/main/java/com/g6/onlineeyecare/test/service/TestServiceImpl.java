package com.g6.onlineeyecare.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.g6.onlineeyecare.exceptions.PatientIdFoundNotException;
import com.g6.onlineeyecare.exceptions.TestIdNotFoundException;
import com.g6.onlineeyecare.patient.dao.IPatientRepository;
import com.g6.onlineeyecare.test.dao.ITestRepository;
import com.g6.onlineeyecare.test.dto.Test;

@Service
public class TestServiceImpl implements ITestService{

	@Autowired
	ITestRepository repository;
	@Autowired
	IPatientRepository patientRepository;
	
	@Override
    @Transactional
    public Test addTest(Test test) throws PatientIdFoundNotException {

        if(patientRepository.findById(test.getPatient().getUserId()).isPresent())
        {
            repository.save(test);
        }
        else
        {
            throw new PatientIdFoundNotException("Patient Id not found");
        }

        return test;
    }

	@Override
	@Transactional
	public Test updateTest(Test test) throws TestIdNotFoundException {
		Optional<Test>optional=null;
			optional=repository.findById(test.getTestId());
			if(optional.isPresent()) {
			repository.save(test);
			}
			else {
				throw new TestIdNotFoundException("Test Id not found for updation");
			}
		return optional.get();
	}

	@Override
	@Transactional
	public Test removeTest(int testId) throws TestIdNotFoundException {
		Optional<Test>optional=null;
		
			optional=repository.findById(testId);
			if(optional.isPresent()) {
			repository.deleteById(testId);
			}
			else {
				throw new TestIdNotFoundException("Test Id not found to remove test");
			}
		return optional.get();
	}

	@Override
	public Test viewTest(int testId) throws TestIdNotFoundException {
		Optional<Test>optional=null;
		
			optional=repository.findById(testId);
			if(optional.isPresent()) {
				repository.findById(testId);
			}
			else {
				throw new TestIdNotFoundException("Test Id not found to view test");
			}
		return optional.get();
	}

	@Override
	public List<Test> viewAllTests() {
		List<Test> testList = null;
		try {
			testList = repository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return testList;
	}

}
