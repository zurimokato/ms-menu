package com.example.ms_menu.domain.model;

import com.example.ms_menu.domain.enums.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
public class Menu {
    private Long id;
    private String name;
    private String url;
    private Status status;
    private Menu parent;
    private List<Menu> children;
}
