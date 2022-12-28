package co.com.accenture.acmsblogapp.service;

import co.com.accenture.acmsblogapp.dto.request.PhotoDTORequest;
import co.com.accenture.acmsblogapp.entity.Photo;

public interface IPhotoService {

	Photo save(PhotoDTORequest request);

}
