package com.example.ms_menu.domain.service;

import com.example.ms_menu.application.port.in.FindMenuUseCase;
import com.example.ms_menu.application.port.in.SaveMenuUseCase;
import com.example.ms_menu.application.port.out.MenuOutPutPort;
import com.example.ms_menu.domain.model.Menu;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MenuService implements FindMenuUseCase, SaveMenuUseCase {
    private final MenuOutPutPort menuOutPutPort;
    @Override
    public Page<Menu> getMenus(Pageable pageable) {
        Page<Menu> menuPage = menuOutPutPort.getMenus(pageable);
        if(menuPage.isEmpty()){
            throw new EntityNotFoundException();
        }
        return menuPage;
    }

    @Override
    public Page<Menu> getMenusByCriteria(Menu criteria, Pageable pageable) {
        return null;
    }

    @Override
    public Menu getMenuById(Long id) {
        return menuOutPutPort.getMenuById(id);
    }

    @Override
    public Menu save(Menu menu) {
        Menu parent=menuOutPutPort.getMenuById(menu.getParent().getId());
        menu.setParent(parent);
        return menuOutPutPort.saveMenu( menu);
    }

    @Override
    public Menu update(Menu menu) {
        Menu oldMenu = menuOutPutPort.getMenuById(menu.getId());
        log.info(oldMenu.toString());
        Menu newMenu = menuOutPutPort.saveMenu(menu);
        return menuOutPutPort.saveMenu(newMenu);
    }
}
