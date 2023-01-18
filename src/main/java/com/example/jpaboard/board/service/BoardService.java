package com.example.jpaboard.board.service;

import com.example.jpaboard.board.domain.Board;
import com.example.jpaboard.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Page<Board> getBoardList(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    public Board getBoard(Long boardId) {
        return boardRepository.findById(boardId)
                .orElseThrow(NoSuchElementException::new);
    }

    @Transactional
    public void createBoard(Board board) {
        boardRepository.save(board);
    }

    @Transactional
    public void updateBoard(Long boardId, Board board) {
        Board getBoard = boardRepository.findById(boardId)
                .orElseThrow(NoSuchElementException::new);

        getBoard.updateBoard(board);
    }

    @Transactional
    public void deleteBoard(Long boardId) {
        Board getBoard = boardRepository.findById(boardId)
                .orElseThrow(NoSuchElementException::new);

        boardRepository.deleteById(getBoard.getBoardId());
    }

}
