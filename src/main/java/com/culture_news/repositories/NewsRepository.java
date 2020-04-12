package com.culture_news.repositories;

import com.culture_news.entity.Category;
import com.culture_news.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findByDate(Date data);
    News findByNews_category(Category category);
}
