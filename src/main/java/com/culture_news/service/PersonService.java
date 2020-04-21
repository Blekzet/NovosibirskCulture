package com.culture_news.service;

import com.culture_news.entity.Persons;
import com.culture_news.repositories.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PersonService {
    @Autowired
    private PersonsRepository personsRepository;

    @Transactional
    public boolean savePerson(Persons person) {
        if (personsRepository.findByPersonName(person.getPersonName()) != null) {
            return false;
        }
        personsRepository.save(person);
        return true;
    }
}
