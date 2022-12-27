package co.com.accenture.acmsblogapp.service;

import java.util.List;

import co.com.accenture.acmsblogapp.dto.request.LoginDTORequest;
import co.com.accenture.acmsblogapp.dto.response.AlbumDTOResponse;
import co.com.accenture.acmsblogapp.dto.response.UserDTOResponse;

public interface IUserService {

	UserDTOResponse login(LoginDTORequest request);
	
	List<AlbumDTOResponse> getAlbumsByUser(Integer userId);
	
	List<UserDTOResponse> getAllUsers();
	
	UserDTOResponse getUserById(Integer userId);
	
}
