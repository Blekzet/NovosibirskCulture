package com.culture_news.service;

import com.culture_news.entity.Affiche;
import com.culture_news.entity.News;
import com.culture_news.entity.Persons;
import com.culture_news.repositories.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class PersonService {
    @Autowired
    private PersonsRepository personsRepository;
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public boolean savePerson(Persons person) {
        if (personsRepository.findByPersonName(person.getPersonName()) != null) {
            return false;
        }
        personsRepository.save(person);
        return true;
    }

    @Transactional
    public boolean savePersonChange(Persons person, Long personId) {
        em.createQuery("UPDATE Persons SET personName = :newName, photo =: newPhoto, description = :newDesc, date = :newDate, occupation =: newOccupation WHERE personId = :id")
                .setParameter("newName", person.getPersonName())
                .setParameter("newPhoto", person.getPhoto())
                .setParameter("newDesc", person.getDescription())
                .setParameter("newDate", person.getDate())
                .setParameter("newOccupation", person.getOccupation())
                .setParameter("id", personId)
                .executeUpdate();
        return true;
    }

    @Transactional
    public boolean deletePerson(Persons person) {
        personsRepository.delete(person);
        return true;
    }
}
