package co.com.accenture.acmsblogapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.accenture.acmsblogapp.dto.request.PhotoDTORequest;
import co.com.accenture.acmsblogapp.entity.Photo;
import co.com.accenture.acmsblogapp.service.IPhotoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/photo")
public class PhotoController {

	@Autowired
	IPhotoService photoService;
	
	@PostMapping
	public ResponseEntity<Photo> create(@Valid @RequestBody PhotoDTORequest request) {
		
		return new ResponseEntity<Photo>(photoService.save(request), HttpStatus.CREATED);
		
	}
	
}
