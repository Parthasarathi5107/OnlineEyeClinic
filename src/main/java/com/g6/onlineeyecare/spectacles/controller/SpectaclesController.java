package com.g6.onlineeyecare.spectacles.controller;

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
import com.g6.onlineeyecare.exceptions.SpectaclesIdNotFoundException;
import com.g6.onlineeyecare.spectacles.dto.Spectacles;
import com.g6.onlineeyecare.spectacles.service.ISpectaclesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@Api(value = "Spectacles Rest Controller", description = "REST APIs related to Spectacles Entity!!!!")
@RestController
@RequestMapping("/spectacles")
public class SpectaclesController {

	@Autowired
	ISpectaclesService spectaclesService;
	
	@ApiOperation(value = "add a new Spectacles",response = Spectacles.class)
	@PostMapping("/add")
	public Spectacles addSpectacles(@RequestBody @Valid Spectacles spectacles) throws PatientIdFoundNotException {
		return	this.spectaclesService.addSpectacles(spectacles);
		
	}
	
	@ApiOperation(value = "update Spectacles",response = Spectacles.class)
	@PutMapping("/update")
	public Spectacles updateSpectacles(@RequestBody Spectacles spectacles) throws SpectaclesIdNotFoundException {
		return this.spectaclesService.updateSpectacles(spectacles);
	}
	
	@ApiOperation(value = "delete Spectacles",response = Spectacles.class)
	@DeleteMapping("/delete/{spectaclesId}")
	public Spectacles deleteSpectacles(@PathVariable("spectaclesId") int spectaclesId) throws SpectaclesIdNotFoundException
	{
		return this.spectaclesService.removeSpectacles(spectaclesId);
	}
	
	@ApiOperation(value = "view Spectacles by Id",response = Spectacles.class)
	@GetMapping("/view/{spectaclesId}")
	public Spectacles viewSpectacles(@PathVariable("spectaclesId")  int spectaclesId ) throws SpectaclesIdNotFoundException {
		return this.spectaclesService.viewSpectacles(spectaclesId);
		
	}
	
	@ApiOperation(value = "view all Spectacles",response = Spectacles.class)
	@GetMapping("/viewAll")
	public List<Spectacles>viewSpectacles(){
		return this.spectaclesService.viewSpectacles();
	}
}
