package com.example.ms_menu.infrastructure.adapter.in.rest.controller;

import com.example.ms_menu.application.port.in.FindMenuUseCase;
import com.example.ms_menu.application.port.in.SaveMenuUseCase;
import com.example.ms_menu.infrastructure.adapter.in.rest.controller.mapper.MenuRestMapper;
import com.example.ms_menu.infrastructure.adapter.in.rest.controller.port.MenuAPIPort;
import com.example.ms_menu.infrastructure.adapter.in.rest.controller.request.MenuRequest;
import com.example.ms_menu.infrastructure.adapter.in.rest.controller.response.GenericResponse;
import com.example.ms_menu.infrastructure.adapter.in.rest.controller.response.MenuResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("v1/menus")
public class MenuController  implements MenuAPIPort {

    private final FindMenuUseCase findMenuUseCase;
    private final SaveMenuUseCase saveMenuUseCase;

    private final MenuRestMapper menuRestMapper;
    @Override
    @Cacheable(value = "menus")
    public GenericResponse getMenus(Pageable pageable) {
        Page<MenuResponse> menuPage=findMenuUseCase.getMenus(pageable).
                map(menuRestMapper::toResponse);
        GenericResponse response=GenericResponse.success();
        response.setData(menuPage.getContent());
        response.setPage(menuRestMapper.toPageResponse(menuPage));
        return response;
    }

    @Override
    @Cacheable(value = "menus", key = "#query")
    public GenericResponse findMenu(MenuRequest query, Pageable pageable) {
        Page<MenuResponse> menuPage=findMenuUseCase.getMenusByCriteria(menuRestMapper.toDomain(query),pageable).
                map(menuRestMapper::toResponse);
        GenericResponse response=GenericResponse.success();
        response.setData(menuPage.getContent());
        response.setPage(menuRestMapper.toPageResponse(menuPage));
        return response;
    }

    @Override
    @Cacheable(value = "menus", key = "#id")
    public GenericResponse findMenuById(Long id) {
        MenuResponse menuResponse=menuRestMapper.toResponse(
                findMenuUseCase.getMenuById(id)
        );
        GenericResponse response=GenericResponse.success();
        response.setData(menuResponse);
        return response;
    }

    @Override
    @CacheEvict(value = "menus", allEntries = true)
    public GenericResponse createMenu(MenuRequest query) {
        MenuResponse menuResponse=menuRestMapper.toResponse(
                saveMenuUseCase.save(menuRestMapper.toDomain(query))
        );
        GenericResponse response=GenericResponse.success();
        response.setData(menuResponse);
        return response;
    }

    @Override
    @CacheEvict(value = "menus", allEntries = true)
    public GenericResponse updateMenu(MenuRequest query) {
        MenuResponse menuResponse=menuRestMapper.toResponse(
                saveMenuUseCase.update(menuRestMapper.toDomain(query))
        );
        GenericResponse response=GenericResponse.success();
        response.setData(menuResponse);
        return response;
    }
}
