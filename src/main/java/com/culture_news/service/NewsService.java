package com.culture_news.service;

import com.culture_news.entity.Category;
import com.culture_news.entity.News;
import com.culture_news.repositories.CategoryRepository;
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
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        news.setDate(formatter.format(date));
        news.setNewsCategory(Collections.singleton(categoryRepository.findByName(category.getName())));
        newsRepository.save(news);

        return true;
    }

    public List<News> fourNewsList() {
        return em.createQuery("SELECT n FROM News n order by n.date desc", News.class).setMaxResults(4).getResultList();
    }
}
