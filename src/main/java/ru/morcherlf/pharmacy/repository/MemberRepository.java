package ru.morcherlf.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.morcherlf.pharmacy.entity.Member;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
