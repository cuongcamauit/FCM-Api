package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.FirebaseMessagingService;
@RestController
@RequestMapping("/notification")
public class NotificationController {
	@Autowired
	FirebaseMessagingService firebaseMessagingService;
	
	@PostMapping
	public ResponseEntity<?> sendNotificationByToken(@RequestBody NotificationMessage notificationMessage) {
		return ResponseEntity.ok(firebaseMessagingService.sendNotificationByToken(notificationMessage));
	}
}
