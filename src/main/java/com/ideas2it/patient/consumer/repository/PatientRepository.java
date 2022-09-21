package com.ideas2it.patient.consumer.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.ideas2it.patient.consumer.entity.PatientDtoDocument;

@Repository
public interface PatientRepository extends ElasticsearchRepository<PatientDtoDocument, Long> {

	List<PatientDtoDocument> findByFirstName(String firstName);

	List<PatientDtoDocument> findByLastName(String lastName);

	List<PatientDtoDocument> findByMedicalRecordNumber(Long mrNumber);

	List<PatientDtoDocument> findByBirthDate(String dob);

}
