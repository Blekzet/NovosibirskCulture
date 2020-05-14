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
    @Transactional
    public boolean saveAfficheChange(Affiche affiche, Affiche oldAffiche) {
        em.createQuery("UPDATE Affiche SET afficheName = :newName WHERE afficheName = :oldName")
                .setParameter("newName" , affiche.getAfficheName())
                .setParameter("oldName" , oldAffiche.getAfficheName())
                .executeUpdate();
        em.createQuery("UPDATE Affiche SET afficheDescriprion = :newDesc WHERE afficheDescriprion = :oldDesc")
                .setParameter("newDesc" , affiche.getAfficheDescriprion())
                .setParameter("oldDesc" , oldAffiche.getAfficheDescriprion())
                .executeUpdate();
        em.createQuery("UPDATE Affiche SET shortDescription = :newShortDesc WHERE shortDescription = :oldShortDesc")
                .setParameter("newShortDesc" , affiche.getShortDescription())
                .setParameter("oldShortDesc" , oldAffiche.getShortDescription())
                .executeUpdate();
        em.createQuery("UPDATE Affiche SET picture = :newPicture WHERE picture = :oldPicture")
                .setParameter("newPicture" , affiche.getPicture())
                .setParameter("oldPicture" , oldAffiche.getPicture())
                .executeUpdate();
        return true;
    }

    @Transactional
    public boolean deleteAffiche(Affiche affiche) {
        afficheRepository.delete(affiche);
        return true;
    }

}
