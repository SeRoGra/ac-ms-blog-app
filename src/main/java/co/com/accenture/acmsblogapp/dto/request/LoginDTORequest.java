package co.com.accenture.acmsblogapp.dto.request;

import javax.validation.constraints.Email;
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
public class LoginDTORequest {

	@NotNull(message = "El campo email no debe ser nulo")
	@NotEmpty(message = "El campo email no debe ser vacío")
	@Email(message = "El campo email no cumple con la estructura de un correo valido")
	private String email;

	@NotNull(message = "El campo password no debe ser nulo")
	@NotEmpty(message = "El campo password no debe ser vacío")
	private String password;

}
