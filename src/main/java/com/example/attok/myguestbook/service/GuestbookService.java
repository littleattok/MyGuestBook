package com.example.attok.myguestbook.service;

import com.example.attok.myguestbook.domain.Guestbook;
import com.example.attok.myguestbook.domain.GuestbookDTO;
import com.example.attok.myguestbook.repository.GuestbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class GuestbookService {

    private final GuestbookRepository guestbookRepository;

    @Autowired
    public GuestbookService(GuestbookRepository guestbookRepository) {
        this.guestbookRepository = guestbookRepository;
    }
    
    //글쓰기
    public Guestbook write(Guestbook guestbook){
        return guestbookRepository.save(guestbook);
    }



    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void addGuestbook(GuestbookDTO guestbookDTO) {
        Guestbook guestbook = new Guestbook();

        guestbook.setNickname(guestbookDTO.getNickname());
        guestbook.setPassword(passwordEncoder.encode(guestbookDTO.getPassword()));
        guestbook.setIp(guestbookDTO.getIp());
        guestbook.setContent(guestbookDTO.getContent());
        guestbook.setRegDate(guestbookDTO.getRegDate());


        // 작성 날짜 자동 설정 -> String을 Date로 바꿨기에 필요 없어짐
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        guestbook.setRegDate(LocalDateTime.now().format(formatter));
        guestbookRepository.save(guestbook);



    }

    public void addEntry(GuestbookDTO newEntry) {
        addGuestbook(newEntry);
    }
    public List<Guestbook> getAllEntries(){
       return guestbookRepository.findAll();
    }

//    public List<Guestbook> findGuestbookByNickname(String nickname){
//        return guestbookRepository.findByNickname(nickname);
//    }
//    public List<Guestbook> findGuestbookByIP(String ip){
//        return guestbookRepository.findByIP(ip);
//    }
    public List<Guestbook> findGuestbookByKeyWord(String keyword){
        return guestbookRepository.findByKeyWord(keyword);
    }





}
