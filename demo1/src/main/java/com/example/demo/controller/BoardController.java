package com.example.demo.controller;

import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import com.example.demo.service.BoardService;
import com.fasterxml.jackson.core.io.DataOutputAsStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Scanner;

@Controller
public class BoardController {
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private BoardService boardService;
    @GetMapping("/board/write") // localhost:8080/board/write
    public String boardWriteForm(){
        return "boardwrite";
    }

    @PostMapping("/board/writepro")
    public String boardWritePro(Board board){

        boardService.boardCreate(board);

        return "";
    }

    @GetMapping("/board/list")
    public String BoardList(Model model){
        List<Board> boards = boardRepository.findAll();
        model.addAttribute("list", boardService.boardList());

        return "boardList";
    }

    @GetMapping("/board/view")  // localhost:8090/board/view?id=1
    public String BoardView(Model model, Integer id){

        model.addAttribute("board", boardService.boardView(id));
        return "boardView";
    }

    @GetMapping("/board/delete")
    public String BoardDelete(Integer id){

        boardService.boardDelete(id);

        return "redirect:/board/list";
    }
}
