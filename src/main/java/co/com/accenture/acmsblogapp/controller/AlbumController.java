package co.com.accenture.acmsblogapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/album")
@Slf4j
public class AlbumController {

	//Registrar album
	@PostMapping
	public ResponseEntity<?> create() {
		
		return null;
		
	}
	
}
