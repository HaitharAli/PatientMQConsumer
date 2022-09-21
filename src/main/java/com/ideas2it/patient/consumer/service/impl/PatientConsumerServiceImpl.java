package com.ideas2it.patient.consumer.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.patient.consumer.entity.PatientDtoDocument;
import com.ideas2it.patient.consumer.repository.PatientRepository;
import com.ideas2it.patient.consumer.service.PatientConsumerService;

@Service
public class PatientConsumerServiceImpl implements PatientConsumerService {

	@Autowired
	private PatientRepository patientRepository;

	@Override
	public int addPatient(PatientDtoDocument patientDto, String string) {
		PatientDtoDocument patientDtoDoc = patientRepository.save(patientDto);
		return patientDtoDoc.getPatientId().intValue();
	}

	@Override
	public Iterable<PatientDtoDocument> findAllPatients() {
		return patientRepository.findAll();
	}

	@Override
	public List<PatientDtoDocument> findPatientByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return patientRepository.findByFirstName(firstName);
	}

	@Override
	public List<PatientDtoDocument> findPatientByLastName(String lastName) {
		return patientRepository.findByLastName(lastName);
	}

	@Override
	public List<PatientDtoDocument> findPatientByMedicalRecordNumber(Long mrNumber) {
		return patientRepository.findByMedicalRecordNumber(mrNumber);
	}

	@Override
	public List<PatientDtoDocument> findPatientByBirthDate(String dob) {
		System.out.println("date inside method : "+dob);
		return patientRepository.findByBirthDate(dob.toString());
	}

}
