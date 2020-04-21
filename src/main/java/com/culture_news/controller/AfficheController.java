package com.culture_news.controller;

import com.culture_news.entity.Affiche;
import com.culture_news.repositories.AfficheRepository;
import com.culture_news.service.AfficheService;
import com.culture_news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AfficheController {
    @Autowired
    private NewsService newsService;
    @Autowired
    private AfficheService afficheService;
    @Autowired
    private AfficheRepository afficheRepository;

    @GetMapping("/editor/addaffiche")
    public String addAffichePage(Model model) {
        model.addAttribute("sidebarData", newsService.fourNewsList());
        model.addAttribute("affiche", new Affiche());
        return "addaffiche";
    }

    @PostMapping("/editor/addaffiche")
    public String addAffiche(@ModelAttribute("affiche") Affiche affiche, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("error", true);
            return "addaffiche";
        }

        if (!afficheService.saveAffiche(affiche)) {
            model.addAttribute("addafficheError", true);
            return "addaffiche";
        }


        return "addaffiche";
    }

    @GetMapping("/affichelist")
    public String afficheList(Model model) {
        model.addAttribute("sidebarData", newsService.fourNewsList());
        model.addAttribute("afficheList", afficheRepository.findAll());
        return "affichelist";
    }

    @GetMapping("/affiche/{afficheId}")
    public String affichePage(@PathVariable Long afficheId, Model model) {
        model.addAttribute("sidebarData", newsService.fourNewsList());
        model.addAttribute("affiche", afficheRepository.getOne(afficheId));
        return "affiche";
    }
}
