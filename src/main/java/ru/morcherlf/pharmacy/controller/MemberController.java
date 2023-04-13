package ru.morcherlf.pharmacy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.morcherlf.pharmacy.entity.Member;
import ru.morcherlf.pharmacy.repository.MemberRepository;

@RestController
@RequiredArgsConstructor
public class MemberController {
    final MemberRepository memberRepository;

//  Add Member
    @PostMapping("/member")
    Member addMember(@RequestBody Member member) {
        return memberRepository.save(member);
    }
}
