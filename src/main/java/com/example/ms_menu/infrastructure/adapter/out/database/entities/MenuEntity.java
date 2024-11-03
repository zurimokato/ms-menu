package com.example.ms_menu.infrastructure.adapter.out.database.entities;

import com.example.ms_menu.domain.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "menus")
public class MenuEntity implements Serializable {
    @Serial
    private static final long serialVersionUID =123423134;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "menu_name")
    private String name;
    @Column(name = "menu_url")
    private String url;
    @Column()
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private MenuEntity parent;
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MenuEntity> children = new ArrayList<>();



}
