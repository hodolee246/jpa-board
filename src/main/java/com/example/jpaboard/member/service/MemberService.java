package com.example.jpaboard.member.service;

import com.example.jpaboard.member.domain.Member;
import com.example.jpaboard.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member getMember(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(NoSuchElementException::new);
    }

    @Transactional
    public void createMember(Member member) {
        memberRepository.save(member);
    }

    @Transactional
    public void updateMember(Long memberId, Member member) {
        Member getMember = memberRepository.findById(memberId)
                .orElseThrow(NoSuchElementException::new);

        member.updateMember(member);
    }

    @Transactional
    public void deleteMember(Long memberId) {
        //FIXME how to delete ? status : realDelete
        memberRepository.deleteById(memberId);
    }

}
