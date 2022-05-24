package com.example.jpaboard.board.controller;

import com.example.jpaboard.board.domain.Board;
import com.example.jpaboard.board.service.BoardService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = {"board"})
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public void getBoardList(Pageable pageable) {
        boardService.getBoardList(pageable);
    }

    @GetMapping("{boardId}")
    public void getBoard(@PathVariable Long boardId) {
        boardService.getBoard(boardId);
    }

    @PostMapping
    public void createBoard(@RequestBody Board board) {
        boardService.createBoard(board);
    }

    @PutMapping("/{boardId}")
    public void updateBoard(@PathVariable Long boardId, @RequestBody Board board) {
        boardService.updateBoard(boardId, board);
    }

    @DeleteMapping("/{boardId}")
    public void deleteBoard(@PathVariable Long boardId) {
        boardService.deleteBoard(boardId);
    }
}
