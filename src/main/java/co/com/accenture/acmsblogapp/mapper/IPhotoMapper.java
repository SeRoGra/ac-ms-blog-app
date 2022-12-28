package co.com.accenture.acmsblogapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.com.accenture.acmsblogapp.dto.request.PhotoDTORequest;
import co.com.accenture.acmsblogapp.dto.response.PhotoDTOResponse;
import co.com.accenture.acmsblogapp.entity.Photo;

@Mapper(componentModel = "spring")
public interface IPhotoMapper {
	
	@Mapping(source = "albumId", target = "album.id")
	Photo toEntity(PhotoDTORequest request);

	@Mapping(target = "id", ignore = true)
	@Mapping(source = "id", target = "photoApiId")
	@Mapping(source = "albumId", target = "album.albumApiId")
	Photo toEntity(PhotoDTOResponse request);
	
}
