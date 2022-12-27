package co.com.accenture.acmsblogapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class ForbiddenServiceException extends RuntimeException{

	public ForbiddenServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ForbiddenServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ForbiddenServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ForbiddenServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ForbiddenServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
