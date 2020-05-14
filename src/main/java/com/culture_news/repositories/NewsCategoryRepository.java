package com.culture_news.repositories;


import com.culture_news.entity.Comments;
import com.culture_news.entity.NewsCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsCategoryRepository extends JpaRepository<NewsCategory, Long> {
}
