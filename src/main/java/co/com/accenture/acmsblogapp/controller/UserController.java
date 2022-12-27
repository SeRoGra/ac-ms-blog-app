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

import co.com.accenture.acmsblogapp.dto.request.LoginDTORequest;
import co.com.accenture.acmsblogapp.dto.response.AlbumDTOResponse;
import co.com.accenture.acmsblogapp.dto.response.UserDTOResponse;
import co.com.accenture.acmsblogapp.service.IUserService;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

	@Autowired
	IUserService userService;

	@PostMapping(path = "/login")
	public ResponseEntity<UserDTOResponse> login(@Valid @RequestBody LoginDTORequest request) {

		return new ResponseEntity<UserDTOResponse>(userService.login(request), HttpStatus.ACCEPTED);

	}

	@GetMapping(path = "/{id}/albums")
	public ResponseEntity<List<AlbumDTOResponse>> getAlbumByUser(@PathVariable(name = "id") Integer userId) {

		return new ResponseEntity<List<AlbumDTOResponse>>(userService.getAlbumsByUser(userId), HttpStatus.OK);

	}

	@GetMapping
	public ResponseEntity<List<UserDTOResponse>> getAllUsers() {

		return new ResponseEntity<List<UserDTOResponse>>(userService.getAllUsers(), HttpStatus.OK);

	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<UserDTOResponse> getUserById(@PathVariable(name = "id") Integer userId) {

		return new ResponseEntity<UserDTOResponse>(userService.getUserById(userId), HttpStatus.OK);

	}

}
