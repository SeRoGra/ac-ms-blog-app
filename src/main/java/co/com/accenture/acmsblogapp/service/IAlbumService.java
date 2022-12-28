package co.com.accenture.acmsblogapp.service;

import java.util.List;

import co.com.accenture.acmsblogapp.dto.request.AlbumDTORequest;
import co.com.accenture.acmsblogapp.entity.Album;
import co.com.accenture.acmsblogapp.entity.Photo;

public interface IAlbumService {
	
	Album save(AlbumDTORequest request);
	
	List<Photo> getPhotosByAlbum(Integer userId);

}
