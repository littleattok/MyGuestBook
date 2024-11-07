package com.example.attok.myguestbook.repository;

import com.example.attok.myguestbook.domain.Guestbook;
import org.springframework.data.jpa.repository.JpaRepository;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;

import java.util.List;

public interface GuestbookRepository extends JpaRepository<Guestbook,Long>,GuestbookRepositoryCustom  {



}
