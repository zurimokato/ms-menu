package com.example.ms_menu.infrastructure.adapter.in.rest.controller.response;


import com.example.ms_menu.domain.enums.Status;
import com.example.ms_menu.infrastructure.adapter.out.database.entities.MenuEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuResponse {
    private Long id;
    private String name;
    private String icon;
    private String url;
    private Status status;
    private List<MenuEntity> children;
    private MenuEntity parent;
}
