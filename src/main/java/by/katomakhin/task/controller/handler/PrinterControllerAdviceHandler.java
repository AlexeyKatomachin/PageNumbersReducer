package by.katomakhin.task.controller.handler;

import by.katomakhin.task.exception.EmptyPageNumbersRowException;
import by.katomakhin.task.exception.InvalidPageNumbersException;
import by.katomakhin.task.exception.message.ExceptionMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class PrinterControllerAdviceHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({EmptyPageNumbersRowException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> emptyPageNumbersRowException(EmptyPageNumbersRowException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({InvalidPageNumbersException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> invalidPageNumbersException(InvalidPageNumbersException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Throwable.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> internalServerError(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ExceptionMessage.INTERNAL_SERVER_ERROR, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
