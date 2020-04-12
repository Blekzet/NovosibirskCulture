package com.culture_news.repositories;

import com.culture_news.entity.Affiche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AfficheRepository extends JpaRepository<Affiche, Long> {
}
