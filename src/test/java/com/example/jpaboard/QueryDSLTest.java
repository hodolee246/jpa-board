package com.example.jpaboard;

import com.example.jpaboard.board.domain.Board;
import com.example.jpaboard.board.repository.BoardRepository;
import com.example.jpaboard.member.domain.Member;
import com.example.jpaboard.member.repository.MemberRepository;
import com.querydsl.core.QueryFactory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.NoSuchElementException;
import java.util.Optional;

@DataJpaTest
public class QueryDSLTest {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    MemberRepository memberRepository;

    private Board insertBoard;
    private Board insertBoard2;
    private Member member;
    private JPAQueryFactory queryFactory;

    @BeforeEach
    void setUp() {
        queryFactory = new JPAQueryFactory(em);

        member = Member.builder()
                .memberId(1L)   // ..? 언제는 박싱해라... 이제는 하지마라...
                .id("id123")
                .pwd("pwd123")
                .build();

        memberRepository.save(member);

        insertBoard = Board
                .builder()
                .boardId(1L)
                .title("title")
                .content("content")
                .member(member)
                .build();

        insertBoard2 = Board
                .builder()
                .boardId(2L)
                .title("title2")
                .content("content2")
                .build();

        boardRepository.save(insertBoard);
        boardRepository.save(insertBoard2);

        System.out.println(boardRepository.findById(1L).get());
        System.out.println(boardRepository.findById(2L).get());
    }

    @AfterEach
    void clear() {
        memberRepository.deleteAll();
        boardRepository.deleteAll();
    }

    @Test
    void memberGet() {
        String memberSql = "select m from Member m";
        Member getMember = (Member) em.createQuery(memberSql).getSingleResult();

        Assertions.assertThat(member.getMemberId()).isEqualTo(getMember.getMemberId());
    }

    @Test
    void boardGet() {
        String boardSql = "select b from Board b";
        Board getBoard = (Board) em.createQuery(boardSql).getSingleResult();

        Assertions.assertThat(insertBoard.getBoardId()).isEqualTo(getBoard.getBoardId());
    }

    @Test
    void queryDsl() {
    }

}
