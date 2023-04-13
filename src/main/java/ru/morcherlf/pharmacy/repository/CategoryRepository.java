package ru.morcherlf.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.morcherlf.pharmacy.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
