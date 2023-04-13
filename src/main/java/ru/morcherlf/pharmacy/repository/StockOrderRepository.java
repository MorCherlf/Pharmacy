package ru.morcherlf.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.morcherlf.pharmacy.entity.StockOrder;

public interface StockOrderRepository extends JpaRepository<StockOrder, Long> {
}
