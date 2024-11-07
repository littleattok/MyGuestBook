package com.example.attok.myguestbook.repository;
import com.example.attok.myguestbook.domain.Guestbook;
import com.example.attok.myguestbook.repository.GuestbookRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class GuestbookRepositoryImpl implements GuestbookRepositoryCustom {
    @PersistenceContext
    private EntityManager entitymanager;

    @Override
    public List<Guestbook> findByNickname(String nickname) {
        String jpql ="select g from Guestbook g where g.nickname= :nickname";
        return entitymanager.createQuery(jpql, Guestbook.class)
                .setParameter("nickname",nickname).getResultList();
    }
}
