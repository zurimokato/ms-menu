package com.example.ms_menu.infrastructure.adapter.out.database;

import com.example.ms_menu.application.port.out.MenuOutPutPort;
import com.example.ms_menu.domain.model.Menu;
import com.example.ms_menu.infrastructure.adapter.out.database.entities.MenuEntity;
import com.example.ms_menu.infrastructure.adapter.out.database.mapper.MenuEntityMapper;
import com.example.ms_menu.infrastructure.adapter.out.database.repositories.MenuRepository;
import com.example.ms_menu.infrastructure.adapter.out.database.repositories.specifications.MenuSpecification;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MenuPersistenceAdapter implements MenuOutPutPort {
    private final MenuRepository menuRepository;
    private final MenuEntityMapper menuEntityMapper;

    @Override
    public Page<Menu> getMenus(Pageable pageable) {
        return menuRepository.findAll(pageable).map(
                menuEntityMapper::toDomain
        );
    }

    @Override
    public Page<Menu> getMenusByCriteria(Menu menu, Pageable pageable) {
        Specification<MenuEntity> spec = MenuSpecification.filterMenus(menu);
        return menuRepository.findAll(spec, pageable).map(menuEntityMapper::toDomain);
    }

    @Override
    public Menu getMenuById(Long id) {

        return menuEntityMapper.toDomain(
                menuRepository.findById(id).orElseThrow(EntityNotFoundException::new)
        );
    }

    @Override
    public Menu saveMenu(Menu menu) {
        return
                menuEntityMapper.toDomain(
                        menuRepository.save(menuEntityMapper.toEntity(menu))
                );
    }

    @Override
    public List<Menu> getMenus() {
        return menuRepository.findAll().stream().map(menuEntityMapper::toDomain).toList();
    }
}
