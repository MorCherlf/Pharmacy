package ru.morcherlf.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.morcherlf.pharmacy.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername (String username);
}
