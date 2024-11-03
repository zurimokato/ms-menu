package com.example.ms_menu.application.port.in;

import com.example.ms_menu.domain.model.Menu;

public interface SaveMenuUseCase {
    Menu save(Menu menu);
    Menu update(Menu menu);
}
