package com.culture_news.service;

import com.culture_news.entity.Affiche;
import com.culture_news.repositories.AfficheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class AfficheService {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private AfficheRepository afficheRepository;


    @Transactional
    public boolean saveAffiche(Affiche affiche) {
        if (afficheRepository.findByAfficheName(affiche.getAfficheName()) != null) {
            return false;
        }

        afficheRepository.save(affiche);
        return true;
    }

}
