package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/demo")
public class MainController {
	@Autowired
	private FCMRepository userRepository;

	@PostMapping("/add")
	public ResponseEntity<?> addNewUser(@RequestParam String token_device, @RequestParam String topic) {
		FCM n = new FCM();
		n.setToken_device(token_device);
		n.setTopic(topic);
		userRepository.save(n);
		return ResponseEntity.ok(n);
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllUsers() {
		// This returns a JSON or XML with the users

		return ResponseEntity.ok(userRepository.findAll());
		// return userRepository.findAll();
	}
}
