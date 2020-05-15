package com.culture_news.repositories;

import com.culture_news.entity.Category;
import com.culture_news.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    public Place findByPlaceName(String placeName);
    public List<Place> findByPlaceCategory(Category category);
}
