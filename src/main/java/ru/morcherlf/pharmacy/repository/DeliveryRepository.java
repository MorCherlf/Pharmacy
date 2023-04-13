package ru.morcherlf.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.morcherlf.pharmacy.entity.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
