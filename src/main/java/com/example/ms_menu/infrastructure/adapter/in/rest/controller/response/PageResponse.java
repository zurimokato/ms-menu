package com.example.ms_menu.infrastructure.adapter.in.rest.controller.response;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageResponse implements Serializable {
    private int size;
    private int totalPages;
    private int totalElements;
    private int number;
    private int numberOfElements;
    private boolean first;
    private boolean last;
    private boolean empty;
}
