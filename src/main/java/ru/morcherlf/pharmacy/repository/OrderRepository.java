package ru.morcherlf.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.morcherlf.pharmacy.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
