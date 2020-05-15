package com.culture_news.repositories;

import com.culture_news.entity.Affiche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AfficheRepository extends JpaRepository<Affiche, Long> {
    public Affiche findByAfficheName(String afficheName);
    public List<Affiche> findByDate(Date date);
}
