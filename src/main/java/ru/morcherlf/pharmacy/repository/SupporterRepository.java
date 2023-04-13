package ru.morcherlf.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.morcherlf.pharmacy.entity.Supporter;

public interface SupporterRepository extends JpaRepository<Supporter, Long> {
}
