package ru.morcherlf.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.morcherlf.pharmacy.entity.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}
