package co.com.accenture.acmsblogapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.com.accenture.acmsblogapp.dto.request.AlbumDTORequest;
import co.com.accenture.acmsblogapp.dto.response.AlbumDTOResponse;
import co.com.accenture.acmsblogapp.entity.Album;

@Mapper(componentModel = "spring")
public interface IAlbumMapper {

	Album toEntity(AlbumDTORequest request);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(source = "id", target = "albumApiId")
	Album toEntity(AlbumDTOResponse request);
	
}
