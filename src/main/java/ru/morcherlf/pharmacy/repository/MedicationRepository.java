package ru.morcherlf.pharmacy.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.morcherlf.pharmacy.entity.Category;
import ru.morcherlf.pharmacy.entity.Medication;

import java.util.List;


@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {
    List<Medication> findByCategory (Category category);
}
