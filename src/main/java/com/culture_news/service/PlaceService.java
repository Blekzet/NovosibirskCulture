package com.culture_news.service;

import com.culture_news.entity.Category;
import com.culture_news.entity.News;
import com.culture_news.entity.Place;
import com.culture_news.repositories.CategoryRepository;
import com.culture_news.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.Collections;
import java.util.List;

@Service
public class PlaceService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public boolean savePlace(Place place, Category category) {
        if (placeRepository.findByPlaceName(place.getPlaceName()) != null) {
            return false;
        }
        if(categoryRepository.findByName(category.getName()) == null){
            return false;
        }

        place.setPlaceCategory(categoryRepository.findByName(category.getName()));
        placeRepository.save(place);
        return true;
    }

    public List<Place> categoryPlace(String name){
        return em.createQuery("SELECT place FROM Place place JOIN place.placeCategory category where category.name = '" + name + "'", Place.class).getResultList();
    }

    @Transactional
    public boolean deletePlace(Place place) {
        placeRepository.delete(place);
        return true;
    }
}
