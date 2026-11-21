package kz.baizhik.menuservice.repositories;

import jakarta.persistence.Entity;
import kz.baizhik.menuservice.model.entites.Drink;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DrinkRepository extends JpaRepository<Drink, Long> {

    @Override
    @EntityGraph(attributePaths = "category")
    Page<Drink> findAll(Pageable pageable);

    @EntityGraph(attributePaths = "category")
    Page<Drink> findByCategoryId(Long id, Pageable pageable);

    @Override
    @EntityGraph(attributePaths = "category")
    Optional<Drink> findById(Long id);

    Page<Drink> findByCategoryId(Long categoryId);

    List<Drink> id(Long id);
}
