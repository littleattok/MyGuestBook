package com.example.attok.myguestbook.repository;

import com.example.attok.myguestbook.domain.Guestbook;

import java.util.List;

public interface GuestbookRepositoryCustom {
    List<Guestbook> findByNickname(String nickname);

    List<Guestbook> findByIP(String ip);
}
