package ru.morcherlf.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.morcherlf.pharmacy.entity.Deliverer;

public interface DelivererRepository extends JpaRepository<Deliverer, Long> {
}
