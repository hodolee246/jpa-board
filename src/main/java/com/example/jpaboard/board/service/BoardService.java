package com.example.jpaboard.board.service;

import com.example.jpaboard.board.domain.Board;
import com.example.jpaboard.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void getBoardList(Pageable pageable) {
        boardRepository.findAll(pageable);
    }

    public void getBoard(Long boardId) {
        boardRepository.findById(boardId)
                .orElseThrow(NoSuchElementException::new);
    }

    public void createBoard(Board board) {
        boardRepository.save(board);
    }

    public void updateBoard(Long boardId, Board board) {
        Board getBoard = boardRepository.findById(boardId)
                .orElseThrow(NoSuchElementException::new);

        getBoard.updateBoard(board);
    }

    public void deleteBoard(Long boardId) {
        boardRepository.deleteById(boardId);
    }

}
