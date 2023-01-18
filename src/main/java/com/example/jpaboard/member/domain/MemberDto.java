package com.example.jpaboard.member.domain;

import com.example.jpaboard.board.domain.Board;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class MemberDto {

    private Long memberId;
    private String id;
    private String pwd;
    private List<Board> boardList;

    @Builder
    public MemberDto(Long memberId, String id, String pwd, List<Board> boardList) {
        this.memberId = memberId;
        this.id = id;
        this.pwd = pwd;
        this.boardList = boardList;
    }

    public Member toEntity() {
        return Member.builder()
                .memberId(this.memberId)
                .id(this.id)
                .pwd(this.pwd)
                .boardList(boardList)
                .build();
    }

}
