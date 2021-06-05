package com.g6.onlineeyecare.patient.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.modelmapper.ModelMapper;
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
import com.g6.onlineeyecare.appointment.dto.Appointment;
import com.g6.onlineeyecare.appointment.dto.AppointmentResponseDTO;
import com.g6.onlineeyecare.exceptions.AppointmentIdNotFoundException;
import com.g6.onlineeyecare.exceptions.DoctorIdNotFoundException;
import com.g6.onlineeyecare.exceptions.PatientIdFoundNotException;
import com.g6.onlineeyecare.patient.dto.Patient;
import com.g6.onlineeyecare.patient.dto.PatientResponseDTO;
import com.g6.onlineeyecare.patient.service.IPatientService;
import com.g6.onlineeyecare.report.dto.Report;
import com.g6.onlineeyecare.report.dto.ReportResponseDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@Api(value = "Patient Rest Controller")
@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	IPatientService patientService;

//	@ApiOperation(value = "create a new Patient profile", response = Patient.class)
//	@PostMapping("/add")
//	public ResponseEntity<PatientResponseDTO> addPatient(@RequestBody @Valid PatientResponseDTO patient) {
//		System.out.println(patient.getDtoPatientAge());
//		Patient p = modelMapper.map(patient, Patient.class);
//		System.out.println("inside rest");
//		Patient req = patientService.addPatient(p);
//		PatientResponseDTO response = modelMapper.map(req, PatientResponseDTO.class);
//		return new ResponseEntity<>(response, HttpStatus.OK);
//	}
//
//	@ApiOperation(value = "Update your profile ", response = Patient.class)
//	@PutMapping("/update")
//	public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient) throws PatientIdFoundNotException {
//		Patient p = this.patientService.updatePatient(patient);
//		return new ResponseEntity<>(p, HttpStatus.OK);
//	}
//
//	@ApiOperation(value = "Delete your profile ", response = Patient.class)
//	@DeleteMapping("/delete/{patientId}")
//	public ResponseEntity<Patient> deletePatient(@PathVariable("patientId") int patientId)
//			throws PatientIdFoundNotException {
//		Patient p = this.patientService.deletePatient(patientId);
//		return new ResponseEntity<>(p, HttpStatus.OK);
//	}
//
//	@ApiOperation(value = "view Patient profile by Id", response = Patient.class)
//	@GetMapping("/view/{patientId}")
//	public ResponseEntity<Patient> viewPatient(@PathVariable("patientId") int patientId)
//			throws PatientIdFoundNotException {
//		Patient p = this.patientService.viewPatient(patientId);
//		return new ResponseEntity<>(p, HttpStatus.OK);
//
//	}
//
//	@ApiOperation(value = "view list of Patients ", response = Patient.class)
//	@GetMapping("/viewAll")
//	public ResponseEntity<List<Patient>> viewPatientList() {
//		List<Patient> p = this.patientService.viewPatientList();
//		return new ResponseEntity<>(p, HttpStatus.OK);
//	}
//
////	@ApiOperation(value = "Book appointment to consult the doctor", response = Appointment.class)
////	@PostMapping("/book")
////	public ResponseEntity<AppointmentResponseDTO> bookAppointment(@RequestBody Appointment appointment)
////			throws DoctorIdNotFoundException, PatientIdFoundNotException {
////		Appointment a = patientService.bookAppointment(appointment);
////		AppointmentResponseDTO response = new AppointmentResponseDTO(a.getAppointmentId(), a.getAppointmentDate(), a.getAppointmentTime(),
////				a.getDoctor().getUserId(), a.getPatient().getUserId());
////		
////		return new ResponseEntity<>(response, HttpStatus.OK);
////
////	}
////
////	@ApiOperation(value = "Get the required appointment by Id ", response = Appointment.class)
////	@GetMapping("/viewAppointmentDetails/{appointmentId}")
////	public ResponseEntity<AppointmentResponseDTO> viewAppointmentDetails(@PathVariable("appointmentId") int appointmentid)
////			throws AppointmentIdNotFoundException {
////		Appointment a = this.patientService.viewAppointmentDetails(appointmentid);
////		AppointmentResponseDTO response = new AppointmentResponseDTO(a.getAppointmentId(), a.getAppointmentDate(), a.getAppointmentTime(),
////				a.getDoctor().getUserId(), a.getPatient().getUserId());
////		
////		return new ResponseEntity<>(response, HttpStatus.OK);
////	}
//
//	@ApiOperation(value = "Get the required Report by patientId ", response = Report.class)
//	@GetMapping("/report/{patientId}")
//	public ResponseEntity<List<ReportResponseDTO>> viewReport(@PathVariable("patientId") int patientId) throws PatientIdFoundNotException {
//		List<Report> r = this.patientService.viewReport(patientId);
//		List<ReportResponseDTO> rlist = new ArrayList<>();
//		for (Report result : r) {
//			ReportResponseDTO response = new ReportResponseDTO(result.getReportId(), result.getDescriptionOfReport(),
//					result.getVisualAcuity(), result.getVisualAcuityNear(), result.getVisualAcuityDistance(),
//					result.getTypeOfTest().getTestId(), result.getPatient().getUserId());
//			rlist.add(response);
//		}
//		return new ResponseEntity<>(rlist, HttpStatus.OK);
//
//	}
}
