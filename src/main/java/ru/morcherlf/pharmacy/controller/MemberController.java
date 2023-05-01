package ru.morcherlf.pharmacy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.morcherlf.pharmacy.entity.Member;
import ru.morcherlf.pharmacy.entity.Shop;
import ru.morcherlf.pharmacy.repository.MemberRepository;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MemberController {
    final MemberRepository memberRepository;

    //  Add Member
    @PostMapping("/member")
    Member addMember(@RequestBody Member member) {
        return memberRepository.save(member);
    }

    //  Get Member by ID
    @GetMapping("/member/{id}")
    Optional<Member> getMember(@PathVariable("id") long id){
        return memberRepository.findById(id);
    }

    //  Edit Member
    @PostMapping("/member/edit")
    Member editMember(@RequestBody Member member){return memberRepository.save(member);}
}
