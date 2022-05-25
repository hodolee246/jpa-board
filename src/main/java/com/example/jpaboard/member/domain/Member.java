package com.example.jpaboard.member.domain;

import com.example.jpaboard.board.domain.Board;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false)
    private String id;
    @Column(nullable = false)
    private String pwd;

    @OneToMany(mappedBy = "boardId", cascade = CascadeType.ALL)
    private List<Board> boardList = new ArrayList<>();

    @Builder
    public Member(Long memberId, String id, String pwd) {
        this.memberId = memberId;
        this.id = id;
        this.pwd = pwd;
    }

}
