package com.culture_news.repositories;


import com.culture_news.entity.PlaceCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceCategoryRepository extends JpaRepository<PlaceCategory, Long> {
}
