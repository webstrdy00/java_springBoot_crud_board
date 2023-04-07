package com.example.demo.repository;

import com.example.demo.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {// entity와 id로 지정한 타입을 지정
    Board findByNickname(String nickname);
//    BoardResposenDto findByNickname(String name);

}
