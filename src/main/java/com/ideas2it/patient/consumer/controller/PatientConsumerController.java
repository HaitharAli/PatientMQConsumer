package com.ideas2it.patient.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.patient.consumer.entity.PatientDtoDocument;
import com.ideas2it.patient.consumer.service.PatientConsumerService;

@RestController
@RequestMapping("/patientmq")
public class PatientConsumerController {

	@Autowired
	public PatientConsumerService patientConsumerService;

//	@PostMapping("/savePatients")
//	public int saveCustomer(@RequestBody List<PatientDtoDocument> patientDtos) {
//		patientConsumerService.addPatient(patientDtos);
//		return patientDtos.size();
//	}

	@GetMapping("/findAll")
	public Iterable<PatientDtoDocument> findAllPatient() {
		return patientConsumerService.findAllPatients();
	}

	@GetMapping("/findByFName/{firstName}")
	public List<PatientDtoDocument> findPatientByFirstName(@PathVariable String firstName) {
		System.out.println("inside firstName");
		return patientConsumerService.findPatientByFirstName(firstName);
	}

	@GetMapping("/findByLName/{lastName}")
	public List<PatientDtoDocument> findPatientByLastName(@PathVariable String lastName) {
		System.out.println("inside lastName");
		return patientConsumerService.findPatientByLastName(lastName);
	}

	@GetMapping("/findByMRNumber/{mrNumber}")
	public List<PatientDtoDocument> findPatientByfindPatientByMRNumber(@PathVariable Long mrNumber) {
		System.out.println("inside mrNumber");
		return patientConsumerService.findPatientByMedicalRecordNumber(mrNumber);
	}

	@GetMapping("/findByDOB/{dob}")
	public List<PatientDtoDocument> findPatientByDOB(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") String dob) {
		System.out.println("inside dob");
		return patientConsumerService.findPatientByBirthDate(dob);
	}

}
