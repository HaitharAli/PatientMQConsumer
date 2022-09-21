package com.ideas2it.patient.consumer.message;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ideas2it.patient.consumer.config.MessagingConfig;
import com.ideas2it.patient.consumer.dto.PatientDto;
import com.ideas2it.patient.consumer.entity.PatientDtoDocument;
import com.ideas2it.patient.consumer.service.PatientConsumerService;

@Component
public class ConsumeMessage {

	@Autowired
	public PatientConsumerService consumerService;
	
	@Autowired
	private ModelMapper mapper;

	@RabbitListener(queues = MessagingConfig.QUEUE)
	public void consumeMessageFromQueue(PatientDto patientDto) {
		System.out.println("Message from queue is: " + patientDto);
		PatientDtoDocument patientDtoDocument =mapper.map(patientDto, PatientDtoDocument.class);
		int patientId = consumerService.addPatient(patientDtoDocument, "I22250");
		System.out.println("patient added successfully with Id: "+patientId);
	}
}
