package ru.morcherlf.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.morcherlf.pharmacy.entity.WorkOrder;

public interface WorkOrderRepository extends JpaRepository<WorkOrder, Long> {
}
