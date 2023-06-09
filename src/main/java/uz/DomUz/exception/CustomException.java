package uz.DomUz.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomException {

    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public ResponseEntity<errorResponse> handleNotFoundException(NotFoundException ex) {
        errorResponse errorResponse = new errorResponse();
        errorResponse.setMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }


    @ExceptionHandler(BadRequestException.class)
    @ResponseBody
    public ResponseEntity<BadRequestExceptionResonse> handleBadRequestExceptions(BadRequestException ex) {
        BadRequestExceptionResonse badRequest = new BadRequestExceptionResonse();
       badRequest.setMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(badRequest);

    }

    @Setter
    @Getter
    public static class errorResponse {
        private String message;
    }

    @Getter
    @Setter
    public static class BadRequestExceptionResonse{
        private String message;
    }


}