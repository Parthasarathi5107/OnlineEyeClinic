package com.g6.onlineeyecare.report.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.g6.onlineeyecare.report.dto.ResponseReportDTO;
import com.g6.onlineeyecare.report.service.IReportService;
import com.g6.onlineeyecare.spectacles.dto.Spectacles;
import com.g6.onlineeyecare.spectacles.dto.SpectaclesResponseDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@Api(value = "Report Rest Controller")
@RestController
@RequestMapping("/report")
public class ReportController {

	@Autowired
	IReportService reportService;

	@ApiOperation(value = "Generate a new report", response = Report.class)
	@PostMapping("/add")
	public ResponseEntity<ResponseReportDTO> addReport(@RequestBody @Valid Report report)
			throws TestIdNotFoundException, PatientIdFoundNotException {
		Report result = this.reportService.addReport(report);
		ResponseReportDTO response = new ResponseReportDTO(result.getReportId(), result.getDescriptionOfReport(),
				result.getVisualAcuity(), result.getVisualAcuityNear(), result.getVisualAcuityDistance(),
				result.getTypeOfTest().getTestId(), result.getPatient().getUserId());

		return new ResponseEntity<ResponseReportDTO>(response, HttpStatus.OK);

	}

	@ApiOperation(value = "Update the specific report", response = Report.class)
	@PutMapping("/update")
	public ResponseEntity<ResponseReportDTO> updateReport(@RequestBody Report report) throws ReportIdNotFoundException {
		Report result = this.reportService.updateReport(report);

		ResponseReportDTO response = new ResponseReportDTO(result.getReportId(), result.getDescriptionOfReport(),
				result.getVisualAcuity(), result.getVisualAcuityNear(), result.getVisualAcuityDistance(),
				result.getTypeOfTest().getTestId(), result.getPatient().getUserId());
		return new ResponseEntity<ResponseReportDTO>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete the report", response = Report.class)
	@DeleteMapping("/delete/{reportId}")
	public ResponseEntity<ResponseReportDTO> deleteReport(@PathVariable("reportId") int reportId)
			throws ReportIdNotFoundException {
		Report result = this.reportService.removeReport(reportId);

		ResponseReportDTO response = new ResponseReportDTO(result.getReportId(), result.getDescriptionOfReport(),
				result.getVisualAcuity(), result.getVisualAcuityNear(), result.getVisualAcuityDistance(),
				result.getTypeOfTest().getTestId(), result.getPatient().getUserId());

		return new ResponseEntity<ResponseReportDTO>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "View the specific report by report id and patient id", response = Report.class)
	@GetMapping("/view/{reportId}/{patientId}")
	public ResponseEntity<ResponseReportDTO> viewReport(@PathVariable("reportId") int reportId,
			@PathVariable("patientId") int patientId) throws ReportIdNotFoundException, PatientIdFoundNotException {
		Report result = this.reportService.viewReport(reportId, patientId);

		ResponseReportDTO response = new ResponseReportDTO(result.getReportId(), result.getDescriptionOfReport(),
				result.getVisualAcuity(), result.getVisualAcuityNear(), result.getVisualAcuityDistance(),
				result.getTypeOfTest().getTestId(), result.getPatient().getUserId());

		return new ResponseEntity<ResponseReportDTO>(response, HttpStatus.OK);

	}

	@ApiOperation(value = "View the specific report by date", response = Report.class)
	@GetMapping("/viewByDate/{date}")
	public ResponseEntity<List<ResponseReportDTO>> viewAllReport(
			@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		List<Report> reportList = this.reportService.viewAllReport(date);
		List<ResponseReportDTO> rlist = new ArrayList<>();
		for (Report result : reportList) {
			ResponseReportDTO response = new ResponseReportDTO(result.getReportId(), result.getDescriptionOfReport(),
					result.getVisualAcuity(), result.getVisualAcuityNear(), result.getVisualAcuityDistance(),
					result.getTypeOfTest().getTestId(), result.getPatient().getUserId());
			rlist.add(response);
		}
		return new ResponseEntity<>(rlist, HttpStatus.OK);
	}

	@ApiOperation(value = "Get the list of Spectacles", response = Spectacles.class)
	@GetMapping("/spectacles")
	public ResponseEntity<List<SpectaclesResponseDTO>> viewSpetacles() {
		List<Spectacles> spectaclesList = this.reportService.viewSpetacles();
		List<SpectaclesResponseDTO> sResponseList = new ArrayList<>();
		for (Spectacles s : spectaclesList) {
			SpectaclesResponseDTO response = new SpectaclesResponseDTO(s.getSpectaclesId(), s.getSpectaclesModel(),
					s.getSpectaclesDescription(), s.getSpectaclesCost(), s.getPatient().getUserId());
			sResponseList.add(response);
		}
		return new ResponseEntity<>(sResponseList, HttpStatus.OK);
	}

}