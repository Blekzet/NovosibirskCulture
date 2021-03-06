package com.culture_news.repositories;

import com.culture_news.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long> {
    public List<Comments> findByNewsId(Long newsId);
    public List<Comments> findByAfficheId(Long afficheId);
}
