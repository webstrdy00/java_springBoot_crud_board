package com.example.demo.service;

import com.example.demo.dto.BoardDeleteDto;
import com.example.demo.dto.BoardRequestDto;
import com.example.demo.dto.BoardResposenDto;
import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor  // 빈을 자동으로 종속시켜주는 코드(모든 생성자를 자동으로 주입시켜주겠다)
@Transactional // 프록시패턴중 하나(안정성떄문에 사용하는 것)
public class BoardService {
    
    private final BoardRepository boardRepository;

    // 글 작성 처리
    public void createBoard(BoardRequestDto boardRequestDto){
        Board board = boardRequestDto.toEntity();
        boardRepository.save(board);
    }

    // 게시글 리스트 처리
    public List<Board> viewBoardList(){
        List<Board> list = boardRepository.findAll();

        return list;
    }
    
    // 특정 게시글 처리
    public BoardResposenDto viewBoard(String nickname){
        Board board = boardRepository.findByNickname(nickname);
        BoardResposenDto boardResposenDto = BoardResposenDto.builder()
                .title(board.getTitle())
                .nickname(board.getNickname())
                .content(board.getContent())
                .build();

        return boardResposenDto;
    }

    // 게시글 수정 처리
    public void updateBoard(BoardRequestDto boardRequestDto){
        Board board = boardRepository.findByNickname(boardRequestDto.getNickname());
        board.update(boardRequestDto);
        boardRepository.save(board);
    }

    // 특정 게시글 삭제
    public void boardDelete(BoardDeleteDto boardDeleteDto){
        Board board = boardRepository.findByNickname(boardDeleteDto.getNickname());
        boardRepository.delete(board);
    }
}
