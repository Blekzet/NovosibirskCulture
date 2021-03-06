package com.culture_news.service;

import com.culture_news.entity.Affiche;
import com.culture_news.entity.Category;
import com.culture_news.entity.Comments;
import com.culture_news.entity.News;
import com.culture_news.repositories.CategoryRepository;
import com.culture_news.repositories.CommentsRepository;
import com.culture_news.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class NewsService{

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CommentsRepository commentsRepository;


    @Transactional
    public boolean saveNewsChange(News news, News oldNews) {
        em.createQuery("UPDATE News SET title = :newTitle WHERE title = :oldTitle")
                .setParameter("newTitle" , news.getTitle())
                .setParameter("oldTitle" , oldNews.getTitle())
                .executeUpdate();
        em.createQuery("UPDATE News SET picture = :newPicture WHERE picture = :oldPicture")
                .setParameter("newPicture" , news.getPicture())
                .setParameter("oldPicture" , oldNews.getPicture())
                .executeUpdate();
        em.createQuery("UPDATE News SET shortDescription = :newShortDesc WHERE shortDescription = :oldShortDesc")
                .setParameter("newShortDesc" , news.getShortDescription())
                .setParameter("oldShortDesc" , oldNews.getShortDescription())
                .executeUpdate();
        em.createQuery("UPDATE News SET fullDescription = :newDesc WHERE fullDescription = :oldDesc")
                .setParameter("newDesc" , news.getFullDescription())
                .setParameter("oldDesc" , oldNews.getFullDescription())
                .executeUpdate();
        return true;
    }

    @Transactional
    public boolean saveNews(News news, Category category) {
        if (newsRepository.findByTitle(news.getTitle()) != null) {
            return false;
        }
        if (newsRepository.findByFullDescription(news.getFullDescription()) != null){
            return false;
        }
        if(categoryRepository.findByName(category.getName()) == null){
            return false;
        }

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy, hh:mm");
        news.setDate(formatter.format(date));
        news.setNewsCategory(categoryRepository.findByName(category.getName()));
        news.setStartCommentsCount(0L);
        newsRepository.save(news);

        return true;
    }

    @Transactional
    public boolean deleteNews(News news) {
        List<Comments> comments = commentsRepository.findByNewsId(news.getNewsId());
        comments.forEach((comment) -> {commentsRepository.delete(comment);});
        newsRepository.delete(news);
        return true;
    }
    public List<News> fourNewsList() {
        return em.createQuery("SELECT n FROM News n order by n.date desc", News.class).setMaxResults(4).getResultList();
    }

    public List<News> threeNewsList() {
        return em.createQuery("SELECT n FROM News n ORDER BY n.commentsCount DESC , n.date DESC", News.class).setMaxResults(3).getResultList();
    }
}
