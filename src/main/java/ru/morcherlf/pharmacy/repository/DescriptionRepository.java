package ru.morcherlf.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.morcherlf.pharmacy.entity.Description;

public interface DescriptionRepository extends JpaRepository<Description, Long> {
}
