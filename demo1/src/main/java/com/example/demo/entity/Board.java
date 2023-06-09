package com.example.demo.entity;

import com.example.demo.dto.BoardRequestDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "board")
@Builder
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String nickname;

    @Column()
    private String content;

    public void update(BoardRequestDto boardRequestDto){
        this.title = boardRequestDto.getTitle();
        this.nickname = boardRequestDto.getNickname();
        this.content = boardRequestDto.getContent();
    }
}
