package com.example.ms_menu.infrastructure.adapter.in.rest.controller.port;

import com.example.ms_menu.infrastructure.adapter.in.rest.controller.request.MenuRequest;
import com.example.ms_menu.infrastructure.adapter.in.rest.controller.response.GenericResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


public interface MenuAPIPort {

    @GetMapping()
    GenericResponse getMenus(Pageable pageable);

    @GetMapping("/find")
    GenericResponse findMenu(@RequestParam MenuRequest query, Pageable pageable);

    @GetMapping("/{id}")
    GenericResponse findMenuById(@PathVariable Long id);

    @PostMapping()
    GenericResponse createMenu(@Valid @RequestBody MenuRequest query);

    @PutMapping
    GenericResponse updateMenu(@Valid @RequestBody MenuRequest query);


}
