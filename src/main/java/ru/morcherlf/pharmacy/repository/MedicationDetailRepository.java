package ru.morcherlf.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.morcherlf.pharmacy.entity.MedicationDetail;

public interface MedicationDetailRepository extends JpaRepository<MedicationDetail, Long> {
}
