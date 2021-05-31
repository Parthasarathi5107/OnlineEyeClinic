package com.g6.onlineeyecare.exceptions;


import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	


	@ExceptionHandler(AppointmentIdNotFoundException.class)
	public ResponseEntity<String> handleAppointmentException(AppointmentIdNotFoundException ex)
	{
		
		HttpHeaders header = new HttpHeaders();
		header.add("Description", "Trying to get Appointment");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());
		
	}
	
	@ExceptionHandler(DoctorIdNotFoundException.class)
	public ResponseEntity<String> handleDoctorException(DoctorIdNotFoundException ex)
	{
		HttpHeaders header = new HttpHeaders();
		header.add("Description", "Trying to get Doctor");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());
	}
	
	@ExceptionHandler(InvalidAppointmentException.class)
	public ResponseEntity<String> handleInvalidAppointmentException(InvalidAppointmentException ex)
	{
		HttpHeaders header = new HttpHeaders();
		header.add("Description", "Trying to get Appointment");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());
	}
	
	@ExceptionHandler(PatientIdFoundNotException.class)
	public ResponseEntity<String> handlePatientException(PatientIdFoundNotException ex)
	{
		HttpHeaders header = new HttpHeaders();
		header.add("Description", "Trying to get Patient");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());
	}
	
	@ExceptionHandler(ReportIdNotFoundException.class)
	public ResponseEntity<String> handleReportException(ReportIdNotFoundException ex)
	{
		HttpHeaders header = new HttpHeaders();
		header.add("Description", "Trying to get Report");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());
	}
	
	@ExceptionHandler(SpectaclesIdNotFoundException.class)
	public ResponseEntity<String> handleSpectaclesException(SpectaclesIdNotFoundException ex)
	{
		HttpHeaders header = new HttpHeaders();
		header.add("Description", "Trying to get Spectacles");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());
	}
	
	@ExceptionHandler(TestIdNotFoundException.class)
	public ResponseEntity<String> handleTestException(TestIdNotFoundException ex)
	{
		HttpHeaders header = new HttpHeaders();
		header.add("Description", "Trying to get Test");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());
	}
	
	@ExceptionHandler(UserIdNotFoundException.class)
	public ResponseEntity<String> handleUserException(UserIdNotFoundException ex)
	{
		HttpHeaders header = new HttpHeaders();
		header.add("Description", "Trying to get User");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		
		Map<String, String> map = new HashMap<>();
		
		
		
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName = ((FieldError)error).getField();
			String msg = error.getDefaultMessage();
			
			map.put(fieldName, msg);
		});
		return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		return new ResponseEntity<Object>("Date format Exception ->"+" Expected Date format: yyyy-MM-dd",HttpStatus.BAD_REQUEST);
	}

}
