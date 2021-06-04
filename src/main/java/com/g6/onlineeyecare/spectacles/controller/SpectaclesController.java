package com.g6.onlineeyecare.spectacles.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.g6.onlineeyecare.exceptions.SpectaclesIdNotFoundException;
import com.g6.onlineeyecare.spectacles.dto.Spectacles;
import com.g6.onlineeyecare.spectacles.dto.SpectaclesResponseDTO;
import com.g6.onlineeyecare.spectacles.service.ISpectaclesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@Api(value = "Spectacles Rest Controller")
@RestController
@RequestMapping("/spectacles")
public class SpectaclesController {

	@Autowired
	ISpectaclesService spectaclesService;

	@ApiOperation(value = "add a new Spectacles", response = Spectacles.class)
	@PostMapping("/add")
	public ResponseEntity<SpectaclesResponseDTO> addSpectacles(@RequestBody @Valid Spectacles spectacles)
			throws PatientIdFoundNotException {
		Spectacles s = this.spectaclesService.addSpectacles(spectacles);
		SpectaclesResponseDTO response = new SpectaclesResponseDTO(s.getSpectaclesId(), s.getSpectaclesModel(),
				s.getSpectaclesDescription(), s.getSpectaclesCost(), s.getPatient().getUserId());

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "update Spectacles", response = Spectacles.class)
	@PutMapping("/update")
	public ResponseEntity<SpectaclesResponseDTO> updateSpectacles(@RequestBody Spectacles spectacles) throws SpectaclesIdNotFoundException {
		Spectacles s = this.spectaclesService.updateSpectacles(spectacles);
		SpectaclesResponseDTO response = new SpectaclesResponseDTO(s.getSpectaclesId(), s.getSpectaclesModel(),
				s.getSpectaclesDescription(), s.getSpectaclesCost(), s.getPatient().getUserId());

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "delete Spectacles", response = Spectacles.class)
	@DeleteMapping("/delete/{spectaclesId}")
	public ResponseEntity<SpectaclesResponseDTO> deleteSpectacles(@PathVariable("spectaclesId") int spectaclesId)
			throws SpectaclesIdNotFoundException {
		Spectacles s = this.spectaclesService.removeSpectacles(spectaclesId);
		SpectaclesResponseDTO response = new SpectaclesResponseDTO(s.getSpectaclesId(), s.getSpectaclesModel(),
				s.getSpectaclesDescription(), s.getSpectaclesCost(), s.getPatient().getUserId());

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@ApiOperation(value = "view Spectacles by Id", response = Spectacles.class)
	@GetMapping("/view/{spectaclesId}")
	public ResponseEntity<SpectaclesResponseDTO> viewSpectacles(@PathVariable("spectaclesId") int spectaclesId)
			throws SpectaclesIdNotFoundException {
		Spectacles s = this.spectaclesService.viewSpectacles(spectaclesId);
		SpectaclesResponseDTO response = new SpectaclesResponseDTO(s.getSpectaclesId(), s.getSpectaclesModel(),
				s.getSpectaclesDescription(), s.getSpectaclesCost(), s.getPatient().getUserId());

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "view all Spectacles", response = Spectacles.class)
	@GetMapping("/viewAll")
	public ResponseEntity<List<SpectaclesResponseDTO>> viewSpectacles() {
		List<Spectacles> spectaclesList = this.spectaclesService.viewSpectacles();
		List<SpectaclesResponseDTO> sResponseList = new ArrayList<>();
		for (Spectacles s : spectaclesList) {
			SpectaclesResponseDTO response = new SpectaclesResponseDTO(s.getSpectaclesId(), s.getSpectaclesModel(),
					s.getSpectaclesDescription(), s.getSpectaclesCost(), s.getPatient().getUserId());
			sResponseList.add(response);
		}
		return new ResponseEntity<>(sResponseList, HttpStatus.OK);
	}
}
