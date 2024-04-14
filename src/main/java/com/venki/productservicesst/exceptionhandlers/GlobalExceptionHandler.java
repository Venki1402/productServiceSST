package com.venki.productservicesst.exceptionhandlers;

import com.venki.productservicesst.dtos.ExceptionDto;
import com.venki.productservicesst.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> arithematicExceptionHandler(){
        ExceptionDto exceptionDto = new ExceptionDto("Something went wrong","check for Arithematic Exception");
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ExceptionDto> arrayIndexOutOfBoundsExceptionHandler(){
        ExceptionDto exceptionDto = new ExceptionDto("Something went wrong","check for Array Index Out Of Bounds Exception");
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ExceptionDto> generalExceptionHandler(){
//        ExceptionDto exceptionDto = new ExceptionDto("Something went wrong","Exception!!");
//        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
//        return responseEntity;
//    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> productNotFoundExceptionHandler(){
        ExceptionDto exceptionDto = new ExceptionDto("Something went wrong","No Product found with the mentioned Id");
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }
}
