package com.example.ms_menu.infrastructure.adapter.out.database.mapper;

import com.example.ms_menu.domain.model.Menu;
import com.example.ms_menu.infrastructure.adapter.out.database.entities.MenuEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MenuEntityMapper {
    @Mapping(target = "parent.children", ignore = true)
    Menu toDomain(MenuEntity source);


    @Mapping(target = "parent",source = "parent")
    @Mapping(target = "parent.children", ignore = true)
    MenuEntity toEntity(Menu source);

}
