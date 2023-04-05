package com.example.demo.repository;

import com.example.demo.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {// entity와 id로 지정한 타입을 지정
    @Modifying
    @Query(value = "INSERT INTO Board(title, content) values(:title, :content)", nativeQuery = true)
    void createBoard(@Param("title") String title, @Param("content") String content);

//    // 전체 게시글 조회
//    List<Board> findAll();
//
//    // 특정 게시글 조회
//    Board findById(int id);
//
//    // 게시글 등록
//    Board save(Board board);
//
//    // 게시글 수정
//    Board update(Board board);
//
//    // 게시글 삭제
//    void deleteById(int id);
    
}
