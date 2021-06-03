package com.g6.onlineeyecare.report.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import com.g6.onlineeyecare.exceptions.ReportIdNotFoundException;
import com.g6.onlineeyecare.exceptions.TestIdNotFoundException;
import com.g6.onlineeyecare.report.dto.Report;
import com.g6.onlineeyecare.report.service.IReportService;
import com.g6.onlineeyecare.spectacles.dto.Spectacles;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@Api(value = "Report Rest Controller", description = "REST APIs related to Report Entity!!!!")
@RestController
@RequestMapping("/report")
public class ReportController {

	@Autowired
	IReportService reportService;

	@ApiOperation(value = "Generate a new report", response = Report.class)
	@PostMapping("/add")
	public Report addReport(@RequestBody @Valid Report report)
			throws TestIdNotFoundException, PatientIdFoundNotException {
		return this.reportService.addReport(report);

	}

	@ApiOperation(value = "Update the specific report", response = Report.class)
	@PutMapping("/update")
	public Report updateReport(@RequestBody Report report) throws ReportIdNotFoundException {
		return this.reportService.updateReport(report);
	}

	@ApiOperation(value = "Delete the report", response = Report.class)
	@DeleteMapping("/delete/{reportId}")
	public Report deleteReport(@PathVariable("reportId") int reportId) throws ReportIdNotFoundException {
		return this.reportService.removeReport(reportId);
	}

	@ApiOperation(value = "View the specific report by report id and patient id", response = Report.class)
	@GetMapping("/view/{reportId}/{patientId}")
	public Report viewReport(@PathVariable("reportId") int reportId, @PathVariable("patientId") int patientId)
			throws ReportIdNotFoundException, PatientIdFoundNotException {
		return this.reportService.viewReport(reportId, patientId);

	}

	@ApiOperation(value = "View the specific report by date", response = Report.class)
	@GetMapping("/viewByDate/{date}")
	public List<Report> viewAllReport(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		return this.reportService.viewAllReport(date);
	}

	@ApiOperation(value = "Get the list of Spectacles", response = Spectacles.class)
	@GetMapping("/spectacles")
	public List<Spectacles> viewSpetacles() {
		return this.reportService.viewSpetacles();
	}
}