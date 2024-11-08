package com.example.attok.myguestbook.domain;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GuestbookDTO {
    private Long id;
    private String nickname;
    private String password;
    private String ip;
    private String content;
    private LocalDateTime regDate;
}
