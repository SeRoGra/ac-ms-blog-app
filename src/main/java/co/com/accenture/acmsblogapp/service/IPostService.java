package co.com.accenture.acmsblogapp.service;

import java.util.List;

import co.com.accenture.acmsblogapp.dto.response.CommentDTOResponse;

public interface IPostService {
	
	List<CommentDTOResponse> getCommentsByPost(Integer postId); 

}
