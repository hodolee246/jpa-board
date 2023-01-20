package com.example.jpaboard.member.controller;

import com.example.jpaboard.member.domain.Member;
import com.example.jpaboard.member.domain.MemberDto;
import com.example.jpaboard.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/{memberId}")
    public Member getMember(@PathVariable Long memberId) {
        return memberService.getMember(memberId);
    }

    @PostMapping
    public void createMember(MemberDto memberDto) {
        memberService.createMember(memberDto.toEntity());
    }

    @PutMapping("/{memberId}")
    public void updateMember(@PathVariable Long memberId, MemberDto memberDto) {
        memberService.updateMember(memberId, memberDto.toEntity());
    }

}
