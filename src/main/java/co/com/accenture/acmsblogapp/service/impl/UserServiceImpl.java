package co.com.accenture.acmsblogapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.accenture.acmsblogapp.client.IPimRestTypicode;
import co.com.accenture.acmsblogapp.dto.request.LoginDTORequest;
import co.com.accenture.acmsblogapp.dto.response.AlbumDTOResponse;
import co.com.accenture.acmsblogapp.dto.response.PhotoDTOResponse;
import co.com.accenture.acmsblogapp.dto.response.PostDTOResponse;
import co.com.accenture.acmsblogapp.dto.response.UserDTOResponse;
import co.com.accenture.acmsblogapp.entity.Album;
import co.com.accenture.acmsblogapp.exception.NotFoundServiceException;
import co.com.accenture.acmsblogapp.exception.ValidateServiceException;
import co.com.accenture.acmsblogapp.mapper.IAlbumMapper;
import co.com.accenture.acmsblogapp.repository.IAlbumRepository;
import co.com.accenture.acmsblogapp.service.IUserService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements IUserService {

	@Autowired
	IPimRestTypicode pimRestTypicode;

	@Autowired
	IAlbumMapper albumMapper;

	@Autowired
	IAlbumRepository albumRepository;

	@Override
	public UserDTOResponse login(LoginDTORequest request) {

		List<UserDTOResponse> usuarios = new ArrayList<>();
		UserDTOResponse response = null;

		log.info("Request: " + request.toString());

		try {
			usuarios = pimRestTypicode.getAllUsers();
		} catch (Exception e) {
			throw new ValidateServiceException(
					"Ha ocurrido el siguiente error al momento del consumo del servicio: " + e.getMessage());
		}

		if (usuarios.size() == 0) {
			throw new NotFoundServiceException("El servicio no retorno ningun usuario");
		}

		response = usuarios.stream().filter(p -> p.getEmail().equals(request.getEmail())).findFirst()
				.orElseThrow(() -> new ValidateServiceException("Usuario y/o contraseña incorrecto"));

		log.info("Response: " + response);

		String pass = response.getUsername().concat("2022");
		log.info("Contraseña: " + pass);

		if (!request.getPassword().equals(pass)) {
			response = null;
			throw new ValidateServiceException("Usuario y/o contraseña incorrecto");
		}

		return response;

	}

	@Override
	public List<Album> getAlbumsByUser(Integer userId) {

		List<Album> response = new ArrayList<>();

		try {

			List<AlbumDTOResponse> albumes = pimRestTypicode.getAlbumsByUser(userId);
			response = albumes.stream().map(p -> albumMapper.toEntity(p)).collect(Collectors.toList());

		} catch (Exception e) {
			log.warn("El usuario no tiene albumes en el servicio");
//			throw new ValidateServiceException(
//					"Ha ocurrido el siguiente error al momento del consumo del servicio: " + e.getMessage());
		}

		// ObtenerAlbumes desde BD del usuario y añadirlas a la lista
		response.addAll(albumRepository.findByUserIdAndAlbumApiIdIsNull(userId.longValue()));

		if (response.size() == 0) {
			throw new NotFoundServiceException("El usuario no tiene ningun album");
		}

		return response;
	}

	@Override
	public List<UserDTOResponse> getAllUsers() {

		List<UserDTOResponse> response = new ArrayList<>();

		try {
			response = pimRestTypicode.getAllUsers();
		} catch (Exception e) {
			throw new ValidateServiceException(
					"Ha ocurrido el siguiente error al momento del consumo del servicio: " + e.getMessage());
		}

		if (response.size() == 0) {
			throw new NotFoundServiceException("No hay usuarios existentes");
		}

		return response;
	}

	@Override
	public UserDTOResponse getUserById(Integer userId) {

		UserDTOResponse response = null;

		try {
			response = pimRestTypicode.getUserById(userId);
		} catch (Exception e) {
			throw new ValidateServiceException(
					"Ha ocurrido el siguiente error al momento del consumo del servicio: " + e.getMessage());
		}

		if (response == null) {
			throw new NotFoundServiceException("El recurso que esta tratando de buscar no fue encontrado");
		}

		return response;
	}

	@Override
	public List<PostDTOResponse> getPostByUser(Integer userId) {

		List<PostDTOResponse> response = null;

		try {
			response = pimRestTypicode.getPostByUser(userId);
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
