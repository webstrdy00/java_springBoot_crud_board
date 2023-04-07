package com.example.demo.controller;

import com.example.demo.dto.BoardDeleteDto;
import com.example.demo.dto.BoardRequestDto;
import com.example.demo.dto.BoardResposenDto;
import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// parm = 중요하지 않은 데이터들을 주로 이것으로 보냄
// json = 암호화해서 데이터를 전송한다
// entity를 dto로 다 바꾸고 
// 로그인을 하면 그사람이 한 cud할 수 있게 만들기
@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardRepository boardRepository;
    private final BoardService boardService;

    // 게시글 작성하기
    @PostMapping("/")
    public ResponseEntity<String> createBoard(@RequestBody BoardRequestDto boardRequestDto){   // RequestBody = json으로 받겠다, RequestParam
        boardService.createBoard(boardRequestDto);
        return ResponseEntity.ok("게시글이 작성되었습니다.");
    }
    
    // 게시글 불러오기
    @GetMapping("/")
    public List<Board> viewBoardList(){
        return boardService.viewBoardList();
    }

    // 특정 게시글 불러오기
    @GetMapping("/board")
    public BoardResposenDto viewBoard(@RequestParam String nickname){
        return boardService.viewBoard(nickname);
    }

    // 게시물 수정하기
    @PutMapping("/")
    public ResponseEntity<String> updateBoard(@RequestBody BoardRequestDto boardRequestDto){
        boardService.updateBoard(boardRequestDto);
        return ResponseEntity.ok("게시글이 수정되었습니다.");
    }

    // 특정게시글 삭제하기
    @DeleteMapping("/")
    public ResponseEntity<String> deleteBoard(@RequestBody BoardDeleteDto boardDeleteDto){
        boardService.boardDelete(boardDeleteDto);
        return ResponseEntity.ok("게시글이 삭제되었습니다.");
    }
}
