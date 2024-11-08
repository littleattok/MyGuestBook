package com.example.attok.myguestbook.controller;

import com.example.attok.myguestbook.domain.Guestbook;
import com.example.attok.myguestbook.domain.GuestbookDTO;
import com.example.attok.myguestbook.service.GuestbookService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GuestbookController {

    private  final GuestbookService guestbookService;

    public GuestbookController(GuestbookService guestbookService){
        this.guestbookService = guestbookService;
    }

    @GetMapping("/guestbook")
    public String viewGuestbook(Model model)
    {
        model.addAttribute("guestbookEntries",guestbookService.getAllEntries());
        model.addAttribute("newEntry",new GuestbookDTO());


        return "guestbook/guestbook";
    }



    private String getClientIP(HttpServletRequest request){
        String clientIP = request.getHeader("X-Forwarded-For");
        if(clientIP== null||clientIP.isEmpty()){
            clientIP=request.getRemoteAddr();
        }
        return clientIP;
    }
    @PostMapping("/guestbook")
    public String addEntry(@ModelAttribute GuestbookDTO newEntry, HttpServletRequest request){
        String clientIP= getClientIP(request);
        newEntry.setIp(clientIP);   //IP주소를 DTO에 설정

        guestbookService.addEntry(newEntry);    //IP가 포함된 DTO 전달
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




    @PostMapping
    public String write(Guestbook guestbook, Model model){
        guestbookService.write(guestbook);
        model.addAttribute("message","방명록이 등록되었습니다.");
        return"redirect:/guestbook/list";
    }
}
