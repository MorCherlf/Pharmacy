package ru.morcherlf.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.morcherlf.pharmacy.entity.StockOrderItem;

public interface StockOrderItemRepository extends JpaRepository<StockOrderItem, Long> {
}
