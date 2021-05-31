package com.g6.onlineeyecare.test.controller;

import java.util.List;

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
import com.g6.onlineeyecare.test.service.ITestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@Api(value = "Test Rest Controller", description = "REST APIs related to Test Entity!!!!")
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    ITestService testService;

    @ApiOperation(value = "Create a new test",response = Test.class)
    @PostMapping("/add")
    public Test addTest(@RequestBody @Valid Test test) throws PatientIdFoundNotException {
        return    this.testService.addTest(test);

    }

    @ApiOperation(value = "Update the specific test",response = Test.class)
    @PutMapping("/update")
    public Test updateTest(@RequestBody Test test) throws TestIdNotFoundException {
        return this.testService.updateTest(test);
    }

    @ApiOperation(value = "Delete the specific test",response = Test.class)
    @DeleteMapping("/delete/{testId}")
    public Test deleteTest(@PathVariable("testId") int testId) throws TestIdNotFoundException
    {
        return this.testService.removeTest(testId);
    }

    @ApiOperation(value = "View the test by Id",response = Test.class)
    @GetMapping("/view/{testId}")
    public Test viewTest(@PathVariable("testId")  int testId ) throws TestIdNotFoundException {
        return this.testService.viewTest(testId);

    }

    @ApiOperation(value = "View all Tests",response = Test.class)
    @GetMapping("/viewAll")
    public List<Test> viewAllTests(){
        return this.testService.viewAllTests();
    }
}