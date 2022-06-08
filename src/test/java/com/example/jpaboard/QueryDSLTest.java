package com.example.jpaboard;

import com.example.jpaboard.board.domain.Board;
import com.example.jpaboard.board.repository.BoardRepository;
import com.example.jpaboard.member.domain.Member;
import com.example.jpaboard.member.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@DataJpaTest
public class QueryDSLTest {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    MemberRepository memberRepository;

    private Board board;
    private Member member;

    @BeforeEach
    void setUp() {
        member = Member.builder()
                .memberId(1L)
                .id("id123")
                .pwd("pwd123")
                .build();

        board = Board
                .builder()
                .boardId(1L)
                .title("title")
                .content("content")
                .member(member)
                .build();

        memberRepository.save(member);
        boardRepository.save(board);
    }

    @AfterEach
    void clear() {
        memberRepository.deleteAll();
        boardRepository.deleteAll();
    }

    @Test
    void get() {
        String memberSql = "select m from Member m";
        Member getMember = (Member) em.createQuery(memberSql).getSingleResult();

        Assertions.assertThat(member.getMemberId()).isEqualTo(getMember.getMemberId());
    }

}
