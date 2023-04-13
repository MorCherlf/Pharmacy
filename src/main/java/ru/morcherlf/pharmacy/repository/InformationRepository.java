package ru.morcherlf.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.morcherlf.pharmacy.entity.Information;

public interface InformationRepository extends JpaRepository<Information, Long> {
}
