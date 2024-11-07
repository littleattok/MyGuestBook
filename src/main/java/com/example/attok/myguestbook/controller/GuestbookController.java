package com.example.attok.myguestbook.controller;

import com.example.attok.myguestbook.service.GuestbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GuestbookController {
    @Autowired
    private GuestbookService guestbookService;

    @GetMapping("/guestbook")
    public String guestbook() {
        return "guestbook";
    }

    @PostMapping("/guestbook")
    public String submitGuestbook() {
        return "redirect:/guestbook";
    }

    @GetMapping("/guestbook/list")
    public String listGuestbook() {
        return "guestbook/list";
    }

    @GetMapping("/guestbook/serachByNickname")
    public String searchGuestbookByNickname(){
        return "guestbook/listNN";
    }
    @GetMapping("/guestbook/searchByIP")
    public String searchGuestbookByIP(){
        return "guestbook/listIP";
    }
}
