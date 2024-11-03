package com.example.ms_menu.application.port.out;

import com.example.ms_menu.domain.model.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MenuOutPutPort {
    Page<Menu> getMenus(Pageable pageable);
    Page<Menu> getMenusByCriteria(Menu menu, Pageable pageable);
    Menu getMenuById(Long id);
    Menu saveMenu(Menu menu);

}
