package com.g6.onlineeyecare.test.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g6.onlineeyecare.exceptions.PatientIdFoundNotException;
import com.g6.onlineeyecare.exceptions.TestIdNotFoundException;
import com.g6.onlineeyecare.test.dto.Test;
import com.g6.onlineeyecare.test.dto.TestResponseDTO;
import com.g6.onlineeyecare.test.service.ITestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@Api(value = "Test Rest Controller")
@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	ITestService testService;

	@ApiOperation(value = "Create a new test", response = Test.class)
	@PostMapping("/add")
	public ResponseEntity<TestResponseDTO> addTest(@RequestBody @Valid Test test) throws PatientIdFoundNotException {
		Test t = this.testService.addTest(test);
		TestResponseDTO response = new TestResponseDTO(t.getTestId(), t.getTestName(), t.getTestType(),
				t.getTestDescription(), t.getTestCost(), t.getPatient().getUserId());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "Update the specific test", response = Test.class)
	@PutMapping("/update")
	public ResponseEntity<TestResponseDTO> updateTest(@RequestBody Test test) throws TestIdNotFoundException {
		Test t = this.testService.updateTest(test);
		TestResponseDTO response = new TestResponseDTO(t.getTestId(), t.getTestName(), t.getTestType(),
				t.getTestDescription(), t.getTestCost(), t.getPatient().getUserId());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete the specific test", response = Test.class)
	@DeleteMapping("/delete/{testId}")
	public ResponseEntity<TestResponseDTO> deleteTest(@PathVariable("testId") int testId)
			throws TestIdNotFoundException {
		Test t = this.testService.removeTest(testId);
		TestResponseDTO response = new TestResponseDTO(t.getTestId(), t.getTestName(), t.getTestType(),
				t.getTestDescription(), t.getTestCost(), t.getPatient().getUserId());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "View the test by Id", response = Test.class)
	@GetMapping("/view/{testId}")
	public ResponseEntity<TestResponseDTO> viewTest(@PathVariable("testId") int testId) throws TestIdNotFoundException {
		Test t = this.testService.viewTest(testId);
		TestResponseDTO response = new TestResponseDTO(t.getTestId(), t.getTestName(), t.getTestType(),
				t.getTestDescription(), t.getTestCost(), t.getPatient().getUserId());
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@ApiOperation(value = "View all Tests", response = Test.class)
	@GetMapping("/viewAll")
	public ResponseEntity<List<TestResponseDTO>> viewAllTests() {
		List<Test> tList = this.testService.viewAllTests();
		List<TestResponseDTO> responseList = new ArrayList<>();
		for (Test t : tList) {
			TestResponseDTO response = new TestResponseDTO(t.getTestId(), t.getTestName(), t.getTestType(),
					t.getTestDescription(), t.getTestCost(), t.getPatient().getUserId());
			responseList.add(response);
		}
		return new ResponseEntity<>(responseList, HttpStatus.OK);
	}
}