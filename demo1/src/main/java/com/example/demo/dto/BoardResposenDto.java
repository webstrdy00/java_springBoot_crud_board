package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@Getter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Transactional
public class BoardResposenDto {
    private String title;
    private String nickname;
    private String content;

}
