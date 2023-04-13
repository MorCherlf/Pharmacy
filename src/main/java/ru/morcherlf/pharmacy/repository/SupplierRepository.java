package ru.morcherlf.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.morcherlf.pharmacy.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
