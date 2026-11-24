package kz.baizhik.serviceorder.repositories;

import kz.baizhik.serviceorder.model.entities.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Page<Order> findByUserId(Long userId, Pageable pageable);

    @Override
    @EntityGraph(attributePaths = "items")
    Optional<Order> findById(Long id);
}
