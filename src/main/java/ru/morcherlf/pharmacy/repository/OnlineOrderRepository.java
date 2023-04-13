package ru.morcherlf.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.morcherlf.pharmacy.entity.OnlineOrder;

public interface OnlineOrderRepository extends JpaRepository<OnlineOrder, Long> {
}
