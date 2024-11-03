package com.example.ms_menu.infrastructure.adapter.in.rest.controller.request;

import com.example.ms_menu.domain.enums.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MenuRequest {
    private Long id;
    private String name;
    private String icon;
    private String url;
    private Status status;
    private Long parentId;

}
