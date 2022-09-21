package com.ideas2it.patient.consumer.entity;

import java.util.Date;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ideas2it.patient.consumer.dto.DiagnosisDto;
import com.ideas2it.patient.consumer.dto.InsuranceDto;
import com.ideas2it.patient.consumer.dto.ReferrerDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName = "patient-clust", shards = 2, createIndex = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDtoDocument {

	@Id
	private Long patientId;
	private Long medicalRecordNumber;
	private Date startCareDate;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date birthDate;
	private String status;
	private String firstName;
	private String lastName;
	private Long phoneNumber;
	private String sex;
	private String maritalStatus;
	private String address;
	private String state;
	private String country;
	private Long zipCode;
	private String email;

	private ReferrerDto referrerDto;

	private DiagnosisDto diagnosisDto;

	private Set<InsuranceDto> insuranceDto;

}
