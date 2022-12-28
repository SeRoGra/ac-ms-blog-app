package co.com.accenture.acmsblogapp.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PhotoDTORequest {
	
	@NotNull(message = "El campo albumId no puede ser nulo")
	private Integer albumId;

	@NotNull(message = "El campo image no puede ser nulo")
	@NotEmpty(message = "El campo image no puede ser vacío")
	private String image;

}
