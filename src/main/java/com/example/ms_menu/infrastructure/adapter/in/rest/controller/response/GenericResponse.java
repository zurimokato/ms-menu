package com.example.ms_menu.infrastructure.adapter.in.rest.controller.response;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponse implements Serializable{
    private String message;
    private String code;
    private transient Object data;
    private PageResponse page;
    private HttpStatus httpStatus;

    public static GenericResponse success() {
        return GenericResponse.builder()
                .code("200")
                .message("OK")
                .httpStatus(HttpStatus.OK)
                .build();
    }

}
