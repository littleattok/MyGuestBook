package com.example.attok.myguestbook.domain;


import lombok.Data;

@Data
public class GuestbookDTO {
    private Long id;
    private String nickname;
    private String password;
    private String ip;
    private String content;
    private String regDate;
}
