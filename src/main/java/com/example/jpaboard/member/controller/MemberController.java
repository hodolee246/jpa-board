package com.example.jpaboard.member.controller;

import com.example.jpaboard.member.domain.Member;
import com.example.jpaboard.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/${memberId}")
    public Member getMember(@PathVariable Long memberId) {
        return memberService.getMember(memberId);
    }

    @PostMapping("/{memberId}")
    public void createMember(Member member) {
        memberService.createMember(member);
    }


}
