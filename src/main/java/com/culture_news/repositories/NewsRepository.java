package com.culture_news.repositories;

import com.culture_news.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    public News findByTitle(String title);
    public News findByFullDescription(String fullDescription);
    public Page<News> findAllByOrderByDateDesc(Pageable pageable);

    @Query("SELECT news FROM News news JOIN news.newsCategory category where category.name = :categoryName")
    Page<News> findByNewsCategory(@Param("categoryName") String categoryName, Pageable pageable);
}
