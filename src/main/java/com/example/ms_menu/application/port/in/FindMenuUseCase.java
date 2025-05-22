package com.example.ms_menu.application.port.in;

import com.example.ms_menu.domain.model.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FindMenuUseCase {

    Page<Menu> getMenus(Pageable pageable);

    Page<Menu> getMenusByCriteria(Menu criteria, Pageable pageable);

    Menu getMenuById(Long id);

    List<Menu> getMenus();

}
