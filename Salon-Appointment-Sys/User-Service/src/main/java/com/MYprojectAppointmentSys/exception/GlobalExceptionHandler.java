package com.MYprojectAppointmentSys.exception;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.MYprojectAppointmentSys.payload.response.ExceptionResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse>ExceptionHandler(Exception ex, 
                                            WebRequest req){
  ExceptionResponse response=new ExceptionResponse(
    ex.getMessage(),
    req.getDescription(false),LocalDateTime.now()
  );
   return ResponseEntity.ok(response);
   }

}

