package ru.morcherlf.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.morcherlf.pharmacy.entity.Staff;

public interface StaffRepository extends JpaRepository<Staff, Long> {
}
