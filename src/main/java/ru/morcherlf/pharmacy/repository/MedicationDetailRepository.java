package ru.morcherlf.pharmacy.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.morcherlf.pharmacy.entity.Category;
import ru.morcherlf.pharmacy.entity.Medication;
import ru.morcherlf.pharmacy.entity.MedicationDetail;
import ru.morcherlf.pharmacy.entity.Shop;

import java.util.List;

public interface MedicationDetailRepository extends JpaRepository<MedicationDetail, Long> {
    Page<MedicationDetail> findByShop(Shop shop, PageRequest of);
}
