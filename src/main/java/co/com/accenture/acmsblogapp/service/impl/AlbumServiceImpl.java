package co.com.accenture.acmsblogapp.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.accenture.acmsblogapp.client.IPimRestTypicode;
import co.com.accenture.acmsblogapp.dto.request.AlbumDTORequest;
import co.com.accenture.acmsblogapp.dto.response.PhotoDTOResponse;
import co.com.accenture.acmsblogapp.entity.Album;
import co.com.accenture.acmsblogapp.entity.Photo;
import co.com.accenture.acmsblogapp.exception.NotFoundServiceException;
import co.com.accenture.acmsblogapp.mapper.IAlbumMapper;
import co.com.accenture.acmsblogapp.mapper.IPhotoMapper;
import co.com.accenture.acmsblogapp.repository.IAlbumRepository;
import co.com.accenture.acmsblogapp.repository.IPhotoRepository;
import co.com.accenture.acmsblogapp.service.IAlbumService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AlbumServiceImpl implements IAlbumService {

	@Autowired
	IAlbumRepository albumRepository;

	@Autowired
	IAlbumMapper albumMapper;
	
	@Autowired
	IPhotoMapper photoMapper;
	
	@Autowired
	IPimRestTypicode pimRestTypicode;
	
	@Autowired
	IPhotoRepository photoRepository;

	@Override
	public Album save(AlbumDTORequest request) {

		Album album = albumMapper.toEntity(request);
		album.setCreatedAt(LocalDateTime.now());
		return albumRepository.save(album);

	}

	@Override
	public List<Photo> getPhotosByAlbum(Integer userId) {
		
		List<Photo> response = new ArrayList<>();
		
		try {
			List<PhotoDTOResponse> photos = pimRestTypicode.getPhotosByAlbum(userId);
			response = photos.stream().map(p -> photoMapper.toEntity(p)).collect(Collectors.toList());
		} catch (Exception e) {
			log.warn("El usuario no tiene photos en el servicio para este album");
			// TODO: handle exception
		}
		
		//ObtenerPhotos desde BD del album
		
		
		if (response.size() == 0) {
			throw new NotFoundServiceException("El usuario no tiene ninguna foto en el album");
		}
		
		return response;
	}

}
