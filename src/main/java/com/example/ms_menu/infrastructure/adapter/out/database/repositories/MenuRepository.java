package com.example.ms_menu.infrastructure.adapter.out.database.repositories;

import com.example.ms_menu.infrastructure.adapter.out.database.entities.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MenuRepository extends JpaRepository<MenuEntity, Long> {
}
