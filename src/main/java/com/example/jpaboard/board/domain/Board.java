package com.example.jpaboard.board.domain;

import com.example.jpaboard.member.domain.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column
    @CreationTimestamp
    private LocalDateTime createAt;

    @Column
    @UpdateTimestamp
    private LocalDateTime updateAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private Member member;

    @Builder
    public Board(Long boardId, String title, String content, LocalDateTime createAt, LocalDateTime updateAt) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public void updateBoard(Board board) {
        this.title = board.getTitle();
        this.content = board.getContent();
    }
}
