package com.example.ms_menu.infrastructure.adapter.out.database.repositories.specifications;

import com.example.ms_menu.domain.model.Menu;
import com.example.ms_menu.infrastructure.adapter.out.database.entities.MenuEntity;
import jakarta.persistence.criteria.Predicate;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class MenuSpecification {
    public static Specification<MenuEntity> filterMenus(Menu menu) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if ( menu.getName() != null && ! menu.getName().isEmpty()) {
                predicates.add(criteriaBuilder.like((root.get("name")), "%" + menu.getName().toLowerCase() + "%"));
            }

            if (menu.getStatus() != null) {
                predicates.add(criteriaBuilder.equal(root.get("status"), menu.getStatus().name()));
            }

            if (menu.getParent().getId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("parent").get("id"), menu.getParent().getId()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
