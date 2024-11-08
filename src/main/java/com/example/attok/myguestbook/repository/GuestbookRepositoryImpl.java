package com.example.attok.myguestbook.repository;

import com.example.attok.myguestbook.domain.Guestbook;
import com.example.attok.myguestbook.domain.QGuestbook;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GuestbookRepositoryImpl implements GuestbookRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    private final JPAQueryFactory queryFactory;

    @Autowired
    public GuestbookRepositoryImpl(EntityManager entityManager) {
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

    // 키워드로 검색 (content 또는 nickname에 포함된 데이터를 찾음)
    @Override
    public List<Guestbook> findByKeyWord(String keyword) {
        QGuestbook guestbook = QGuestbook.guestbook;

        return queryFactory.selectFrom(guestbook)
                .where(guestbook.content.contains(keyword) // content에 keyword가 포함되면
                        .or(guestbook.nickname.contains(keyword))) // 또는 nickname에 keyword가 포함되면
                .fetch();
    }



//    @PersistenceContext
//    private EntityManager entitymanager;

//    @Override
//    public List<Guestbook> findByNickname(String nickname) {
//        String jpql ="select g from Guestbook g where g.nickname= :nickname";
//        return entitymanager.createQuery(jpql, Guestbook.class)
//                .setParameter("nickname",nickname).getResultList();
//    }

//    @Override
//    public List<Guestbook> findByIP(String ip) {
//        String jpql ="select g from Guestbook g where g.nickname= :ip";
//        return entitymanager.createQuery(jpql, Guestbook.class)
//                .setParameter("ip",ip).getResultList();
//    }
}
