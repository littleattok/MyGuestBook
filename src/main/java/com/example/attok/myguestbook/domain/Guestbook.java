package com.example.attok.myguestbook.domain;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@Entity
@Table(name="GUESTBOOK")
public class Guestbook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;        // id

    @Column(nullable=false)
    private String nickname;    // 닉네임

    @Column(nullable=false)
    private String password;    // 비밀번호

    @Column(nullable=false)
    private String ip;         // IP주소

    @Column(nullable=false, length=1000)
    private String content;     // 본문

    @CreationTimestamp
    @Column(nullable=false, updatable=false)
    private LocalDateTime regDate;     // 등록일

}
