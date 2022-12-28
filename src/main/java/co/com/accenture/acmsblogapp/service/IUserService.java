package co.com.accenture.acmsblogapp.service;

import java.util.List;

import co.com.accenture.acmsblogapp.dto.request.LoginDTORequest;
import co.com.accenture.acmsblogapp.dto.response.AlbumDTOResponse;
import co.com.accenture.acmsblogapp.dto.response.PhotoDTOResponse;
import co.com.accenture.acmsblogapp.dto.response.PostDTOResponse;
import co.com.accenture.acmsblogapp.dto.response.UserDTOResponse;
import co.com.accenture.acmsblogapp.entity.Album;

public interface IUserService {

	UserDTOResponse login(LoginDTORequest request);
	
	List<Album> getAlbumsByUser(Integer userId);
	
	List<PostDTOResponse> getPostByUser(Integer userId);
	
	List<UserDTOResponse> getAllUsers();
	
	UserDTOResponse getUserById(Integer userId);
	
}
