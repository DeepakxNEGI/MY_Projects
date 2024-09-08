package com.MYproject2.EmailSenderApp.api;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CustomResponse {
    private  String message;
    private HttpStatus httpStatus;
    private boolean success= false;
}
