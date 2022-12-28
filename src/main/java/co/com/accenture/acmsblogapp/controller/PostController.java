package co.com.accenture.acmsblogapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.accenture.acmsblogapp.dto.response.CommentDTOResponse;
import co.com.accenture.acmsblogapp.service.IPostService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	IPostService postService;

	@GetMapping(path = "/{id}/comments")
	public ResponseEntity<List<CommentDTOResponse>> getCommentsByPost(@PathVariable(name = "id") Integer postId) {

		return new ResponseEntity<List<CommentDTOResponse>>(postService.getCommentsByPost(postId), HttpStatus.OK);

	}

}
