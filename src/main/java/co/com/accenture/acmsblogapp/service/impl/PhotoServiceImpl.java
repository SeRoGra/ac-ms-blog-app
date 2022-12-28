package co.com.accenture.acmsblogapp.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.accenture.acmsblogapp.dto.request.PhotoDTORequest;
import co.com.accenture.acmsblogapp.entity.Photo;
import co.com.accenture.acmsblogapp.mapper.IPhotoMapper;
import co.com.accenture.acmsblogapp.repository.IPhotoRepository;
import co.com.accenture.acmsblogapp.service.IPhotoService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PhotoServiceImpl implements IPhotoService {

	@Autowired
	IPhotoMapper photoMapper;
	
	@Autowired
	IPhotoRepository photoRepository;
	
	@Override
	public Photo save(PhotoDTORequest request) {
		
		log.info("Request: " + request.toString());
		
		Photo photo = photoMapper.toEntity(request);
		photo.setCreatedAt(LocalDateTime.now());
		return photoRepository.save(photo);
	}

}
