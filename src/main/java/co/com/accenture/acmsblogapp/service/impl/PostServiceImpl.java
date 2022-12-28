package co.com.accenture.acmsblogapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.accenture.acmsblogapp.client.IPimRestTypicode;
import co.com.accenture.acmsblogapp.dto.response.CommentDTOResponse;
import co.com.accenture.acmsblogapp.exception.NotFoundServiceException;
import co.com.accenture.acmsblogapp.exception.ValidateServiceException;
import co.com.accenture.acmsblogapp.service.IPostService;

@Service
public class PostServiceImpl implements IPostService {

	@Autowired
	IPimRestTypicode pimRestTypicode;
	
	@Override
	public List<CommentDTOResponse> getCommentsByPost(Integer postId) {
		
		List<CommentDTOResponse> response = new ArrayList<>();
		
		try {
			response = pimRestTypicode.getCommentsByPost(postId);
		} catch (Exception e) {
			throw new ValidateServiceException(
					"Ha ocurrido el siguiente error al momento del consumo del servicio: " + e.getMessage());
		}
		
		if (response == null) {
			throw new NotFoundServiceException("El recurso que esta tratando de buscar no fue encontrado");
		}
		
		return response;
	}

}
