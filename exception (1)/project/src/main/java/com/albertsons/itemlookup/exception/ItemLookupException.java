package com.albertsons.itemlookup.exception;

import com.albertsons.itemlookup.resources.model.Error;
import com.albertsons.itemlookup.resources.model.Errors;
import com.mongodb.MongoSocketOpenException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.context.request.WebRequest;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;


@ControllerAdvice
public class ItemLookupException {

    @ExceptionHandler(MongoSocketOpenException.class)
    public ResponseEntity<Errors> mongoSocketOpenExceptionHandler(Exception ex, WebRequest request) {
        Error error = Error.builder()
                .category(ItemLookupExceptionConstants.DATABASE_EXCEPTION.getCategory())
                .code(ItemLookupExceptionConstants.DATABASE_EXCEPTION.getCode())
                .message(ex.getMessage())
                .type(ItemLookupExceptionConstants.DATABASE_EXCEPTION.getType())
                .vendor(ItemLookupExceptionConstants.DATABASE_EXCEPTION.getVendor())
                .build();
        Errors errors = Errors.builder()
                .errors(Arrays.asList(error))
                .build();
        return new ResponseEntity<Errors>(errors, HttpStatus.OK);
    }

    @ExceptionHandler(UrlNotFoundException.class)
    public ResponseEntity<Errors> urlNotFoundExceptionHandler(Exception ex, WebRequest request) {
        Error error = Error.builder()
                .category(ItemLookupExceptionConstants.INVALID_URL.getCategory())
                .code(ItemLookupExceptionConstants.INVALID_URL.getCode())
                .message(ItemLookupExceptionConstants.INVALID_URL.getMessage())
                .type(ItemLookupExceptionConstants.INVALID_URL.getType())
                .vendor(ItemLookupExceptionConstants.INVALID_URL.getVendor())
                .build();
        Errors errors = Errors.builder()
                .errors(Arrays.asList(error))
                .build();
        return new ResponseEntity<Errors>(errors, HttpStatus.OK);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<Errors> ioExceptionHandler(Exception ex, WebRequest request) {
        Error error = Error.builder()
                .category(ItemLookupExceptionConstants.FILE_NOT_FOUND.getCategory())
                .code(ItemLookupExceptionConstants.FILE_NOT_FOUND.getCode())
                .message(ItemLookupExceptionConstants.FILE_NOT_FOUND.getMessage())
                .type(ItemLookupExceptionConstants.FILE_NOT_FOUND.getType())
                .vendor(ItemLookupExceptionConstants.FILE_NOT_FOUND.getVendor())
                .build();
        Errors errors = Errors.builder()
                .errors(Arrays.asList(error))
                .build();
        return new ResponseEntity<Errors>(errors, HttpStatus.OK);
    }

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<Errors> itemNotFoundExceptionHandler(Exception ex, WebRequest request) {
        Error error = Error.builder()
                .category(ItemLookupExceptionConstants.ITEM_NOT_FOUND.getCategory())
                .code(ItemLookupExceptionConstants.ITEM_NOT_FOUND.getCode())
                .message(ItemLookupExceptionConstants.ITEM_NOT_FOUND.getMessage())
                .type(ItemLookupExceptionConstants.ITEM_NOT_FOUND.getType())
                .vendor(ItemLookupExceptionConstants.ITEM_NOT_FOUND.getVendor())
                .build();
        Errors errors = Errors.builder()
                .errors(Arrays.asList(error))
                .build();
        return new ResponseEntity<Errors>(errors, HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Errors> exceptionHandler(Exception ex, WebRequest request) {
        Error error = Error.builder()
                .category(ItemLookupExceptionConstants.EXCEPTION.getCategory())
                .code(ItemLookupExceptionConstants.EXCEPTION.getCode())
                .message(ex.getMessage())
                .type(ItemLookupExceptionConstants.EXCEPTION.getType())
                .vendor(ItemLookupExceptionConstants.EXCEPTION.getVendor())
                .build();
        Errors errors = Errors.builder()
                .errors(Arrays.asList(error))
                .build();
        return new ResponseEntity<Errors>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}


