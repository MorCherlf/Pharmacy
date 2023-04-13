package ru.morcherlf.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.morcherlf.pharmacy.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
