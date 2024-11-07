package com.example.attok.myguestbook.service;

import com.example.attok.myguestbook.domain.Guestbook;
import com.example.attok.myguestbook.domain.GuestbookDTO;
import com.example.attok.myguestbook.repository.GuestbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class GuestbookService {

    @Autowired
    private GuestbookRepository guestbookRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void addGuestbook(GuestbookDTO guestbookDTO) {
        Guestbook guestbook = new Guestbook();

        guestbook.setNickName(guestbookDTO.getNickname());
        guestbook.setPassword(passwordEncoder.encode(guestbookDTO.getPassword()));
        guestbook.setIP(guestbookDTO.getIp());
        guestbook.setContent(guestbookDTO.getContent());
        guestbook.setRegDate(guestbookDTO.getRegDate());


        // 작성 날짜 자동 설정
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        guestbook.setRegDate(LocalDateTime.now().format(formatter));

        guestbookRepository.save(guestbook);
    }
}
