package com.example.ms_menu.infrastructure.adapter.in.rest.controller.mapper;

import com.example.ms_menu.domain.model.Menu;
import com.example.ms_menu.infrastructure.adapter.in.rest.controller.request.MenuRequest;
import com.example.ms_menu.infrastructure.adapter.in.rest.controller.response.MenuResponse;
import com.example.ms_menu.infrastructure.adapter.in.rest.controller.response.PageResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface MenuRestMapper {

    @Mapping(target = "children", ignore = true)
    @Mapping(target = "parent.id", source = "parentId")
    Menu toDomain(MenuRequest menuRequest);

    MenuResponse toResponse(Menu menu);

    PageResponse toPageResponse(Page<MenuResponse> page);
}
