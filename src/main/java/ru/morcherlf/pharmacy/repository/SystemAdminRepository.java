package ru.morcherlf.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.morcherlf.pharmacy.entity.SystemAdmin;

public interface SystemAdminRepository extends JpaRepository<SystemAdmin, Long> {
}
