package com.ideas2it.patient.consumer.service;

import java.util.Date;
import java.util.List;

import com.ideas2it.patient.consumer.entity.PatientDtoDocument;

public interface PatientConsumerService {

	int addPatient(PatientDtoDocument patientDto, String string);

	Iterable<PatientDtoDocument> findAllPatients();

	List<PatientDtoDocument> findPatientByFirstName(String firstName);

	List<PatientDtoDocument> findPatientByLastName(String lastName);

	List<PatientDtoDocument> findPatientByMedicalRecordNumber(Long mrNumber);

	List<PatientDtoDocument> findPatientByBirthDate(String dob);

}
