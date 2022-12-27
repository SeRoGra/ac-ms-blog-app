package co.com.accenture.acmsblogapp.config;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import co.com.accenture.acmsblogapp.exception.ForbiddenServiceException;
import co.com.accenture.acmsblogapp.exception.GeneralServiceException;
import co.com.accenture.acmsblogapp.exception.NotFoundServiceException;
import co.com.accenture.acmsblogapp.exception.UnauthorizedServiceException;
import co.com.accenture.acmsblogapp.exception.ValidateServiceException;
import co.com.accenture.acmsblogapp.util.WrapperResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ErrorHandlerConfig extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> all(Exception e, WebRequest request) {
		log.error(e.getMessage(), e);

		WrapperResponse<?> response = new WrapperResponse<>(false, "Internal Server Error", null);

		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ValidateServiceException.class)
	public ResponseEntity<?> validateServiceException(ValidateServiceException e, WebRequest request) {
		log.info(e.getMessage(), e);

		WrapperResponse<?> response = new WrapperResponse<>(false, e.getMessage(), null);

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NotFoundServiceException.class)
	public ResponseEntity<?> notFoundException(NotFoundServiceException e, WebRequest request) {
		log.info(e.getMessage(), e);

		WrapperResponse<?> response = new WrapperResponse<>(false, e.getMessage(), null);

		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(GeneralServiceException.class)
	public ResponseEntity<?> generalServiceException(GeneralServiceException e, WebRequest request) {
		log.error(e.getMessage(), e);

		WrapperResponse<?> response = new WrapperResponse<>(false, "Internal Server Error", null);

		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UnauthorizedServiceException.class)
	public ResponseEntity<?> unauthorizedServiceException(UnauthorizedServiceException e, WebRequest request) {
		log.error(e.getMessage(), e);

		WrapperResponse<?> response = new WrapperResponse<>(false, e.getMessage(), null);

		return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(ForbiddenServiceException.class)
	public ResponseEntity<?> forbiddenServiceException(ForbiddenServiceException e, WebRequest request) {
		log.error(e.getMessage(), e);

		WrapperResponse<?> response = new WrapperResponse<>(false, e.getMessage(), null);

		return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
	}

	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<FieldError> bindingResult = ex.getBindingResult().getFieldErrors();
		List<String> errors = bindingResult.stream().map(n -> n.getDefaultMessage()).collect(Collectors.toList());

		WrapperResponse<?> response = new WrapperResponse<>(false,
				"Se presentaron los siguiente errores en la petición", errors);

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

	}
}
