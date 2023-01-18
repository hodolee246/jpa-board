package com.example.jpaboard.member.domain;

import com.example.jpaboard.board.domain.Board;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false)
    private String id;
    @Column(nullable = false)
    private String pwd;

    @OneToMany(mappedBy = "boardId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Board> boardList = new ArrayList<>();

    @Builder
    public Member(Long memberId, String id, String pwd, List<Board> boardList) {
        this.memberId = memberId;
        this.id = id;
        this.pwd = pwd;
        this.boardList = boardList;
    }

    public void updateMember(Member member) {
        if (! "".equals(member.getId())) {
            this.id = member.getId();
        }

        if (! "".equals(member.getPwd())) {
            this.pwd = member.getPwd();
        }

        if (! member.getBoardList().isEmpty()) {
            this.boardList = member.getBoardList();
        }
    }


    public MemberDto toDto() {
        return MemberDto.builder()
                .memberId(this.memberId)
                .id(this.id)
                .pwd(this.pwd)
                .boardList(this.boardList)
                .build();
    }

}
