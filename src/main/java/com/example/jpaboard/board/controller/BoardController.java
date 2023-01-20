package com.example.jpaboard.board.controller;

import com.example.jpaboard.board.domain.Board;
import com.example.jpaboard.board.service.BoardService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = {"board"})
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public ResponseEntity<?> getBoardList(Pageable pageable) {
        return ResponseEntity.ok().body(boardService.getBoardList(pageable));
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<?> getBoard(@PathVariable Long boardId) {
        return ResponseEntity.ok().body(boardService.getBoard(boardId));
    }

    @PostMapping
    public ResponseEntity<?> createBoard(@RequestBody Board board) {
        boardService.createBoard(board);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{boardId}")
    public ResponseEntity<?> updateBoard(@PathVariable Long boardId, @RequestBody Board board) {
        boardService.updateBoard(boardId, board);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{boardId}")
    public ResponseEntity<?> deleteBoard(@PathVariable Long boardId) {
        boardService.deleteBoard(boardId);

        return ResponseEntity.ok().build();
    }
}
