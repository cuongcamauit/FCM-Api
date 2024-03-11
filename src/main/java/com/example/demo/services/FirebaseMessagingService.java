package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.NotificationMessage;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;

@Service
public class FirebaseMessagingService {
	@Autowired
	private FirebaseMessaging firebaseMessaging;
	
	public String sendNotificationByToken(NotificationMessage notificationMessage) {
		Notification notification = Notification
				.builder()
				.setTitle(notificationMessage.getTitle())
				.setBody(notificationMessage.getBody())
				.setImage(notificationMessage.getImage())
				.build();
		
		Message message = Message
				.builder()
				.setToken(notificationMessage.getRecipientToken())
				.setNotification(notification)
				.putAllData(notificationMessage.getData())
				.build();
		
	try {
		firebaseMessaging.send(message);
		return "Success Sending Notification";
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		return "Error Sending Notification";
	}
	}
}
