package co.com.accenture.acmsblogapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.accenture.acmsblogapp.dto.request.AlbumDTORequest;
import co.com.accenture.acmsblogapp.entity.Album;
import co.com.accenture.acmsblogapp.entity.Photo;
import co.com.accenture.acmsblogapp.service.IAlbumService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/album")
public class AlbumController {
	
	@Autowired
	IAlbumService albumService;
	
	@PostMapping
	public ResponseEntity<Album> create(@Valid @RequestBody AlbumDTORequest request) {
		
		return new ResponseEntity<Album>(albumService.save(request), HttpStatus.CREATED);
		
	}

	@GetMapping(path = "/{id}/photos")
	public ResponseEntity<List<Photo>> getPhotosByAlbum(@PathVariable(name = "id") Integer albumId) {
		
		return new ResponseEntity<List<Photo>>(albumService.getPhotosByAlbum(albumId), HttpStatus.OK);
		
	}
	
}
