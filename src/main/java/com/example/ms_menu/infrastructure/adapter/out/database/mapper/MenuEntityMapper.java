package com.example.ms_menu.infrastructure.adapter.out.database.mapper;

import com.example.ms_menu.domain.model.Menu;
import com.example.ms_menu.infrastructure.adapter.out.database.entities.MenuEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MenuEntityMapper {

    Menu toDomain(MenuEntity source);

    MenuEntity toEntity(Menu source);

}
