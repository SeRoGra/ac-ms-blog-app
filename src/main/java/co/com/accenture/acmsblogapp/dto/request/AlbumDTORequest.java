package co.com.accenture.acmsblogapp.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDTORequest {
	
	@NotNull(message = "El campo title no puede ser nulo")
	@NotEmpty(message = "El campo title no puede ser vacío")
	private String title;
	
	@NotNull(message = "El campo userId no puede ser nulo")
	private Integer userId;

}
