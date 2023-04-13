package ru.morcherlf.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.morcherlf.pharmacy.entity.Introduction;

public interface IntroductionRepository extends JpaRepository<Introduction, Long> {
}
