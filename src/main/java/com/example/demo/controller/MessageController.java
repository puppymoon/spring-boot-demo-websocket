package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import com.example.demo.dto.MessageBody;

@Controller
public class MessageController {

	@Autowired
	private SimpMessageSendingOperations simpMessageSendingOperations;

	@MessageMapping("/test")
	public void sendTopicMessage(MessageBody messageBody) {
		simpMessageSendingOperations.convertAndSend(messageBody.getDestination(), messageBody);
	}

}
