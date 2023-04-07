package com.example.demo.dto;

import com.example.demo.entity.Board;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BoardRequestDto {
    private String title;
    private String nickname;
    private String content;

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .nickname(nickname)
                .build();
    }
}
