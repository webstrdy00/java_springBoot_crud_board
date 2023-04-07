package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "board")
@Builder
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String nickname;

    @Column()
    private String content;

    @Column()
    private String introduce;

}
