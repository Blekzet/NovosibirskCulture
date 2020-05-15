package com.culture_news.controller;

import com.culture_news.entity.Comments;
import com.culture_news.entity.News;
import com.culture_news.entity.Persons;
import com.culture_news.repositories.CommentsRepository;
import com.culture_news.repositories.PersonsRepository;
import com.culture_news.service.NewsService;
import com.culture_news.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonController {

    @Autowired
    private PersonsRepository personsRepository;
    @Autowired
    private NewsService newsService;
    @Autowired
    private PersonService personService;
    @Autowired
    private CommentsRepository commentsRepository;

    @GetMapping("/editor/addperson")
    public String addPersonPage(Model model) {
        model.addAttribute("sidebarData", newsService.fourNewsList());
        model.addAttribute("person", new Persons());
        return "addperson";
    }

    @PostMapping("/editor/addperson")
    public String addPerson(@ModelAttribute("person") Persons person, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("error", true);
            return "addperson";
        }

        if (!personService.savePerson(person)) {
            model.addAttribute("addpersonError", true);
            return "addperson";
        }


        return "addperson";
    }

    @GetMapping("/editor/deletePerson/{personId}")
    public String deletePerson(@PathVariable Long personId, Model model) {
        personService.deletePerson(personsRepository.getOne(personId));
        return "redirect:/";
    }
    @GetMapping("/editor/changePerson/{personId}")
    public String changePerson(@PathVariable Long personId, Model model) {
        model.addAttribute("sidebarData", newsService.fourNewsList());
        model.addAttribute("person", personsRepository.getOne(personId));
        return "changePerson";
    }


    @PostMapping("/editor/changePerson/{personId}")
    public String changePersonSave(@PathVariable Long personId, @ModelAttribute("person") Persons person, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("error", true);
            return "changePerson";
        }

        if (!personService.savePersonChange(person, personId)) {
            model.addAttribute("addError", true);
            return "changePerson";
        }

        return "redirect:/person/" + personId;
    }

    @GetMapping("/personlist")
    public String personListPage(Model model){
        model.addAttribute("sidebarData", newsService.fourNewsList());
        model.addAttribute("personlist", personsRepository.findAll());
        return "personlist";
    }
    @GetMapping("/person/{personId}")
    public String personPage(Model model, @PathVariable Long personId){
        model.addAttribute("sidebarData", newsService.fourNewsList());
        model.addAttribute("saveComment", new Comments());
        model.addAttribute("person", personsRepository.getOne(personId));
        return "person";
    }
}
