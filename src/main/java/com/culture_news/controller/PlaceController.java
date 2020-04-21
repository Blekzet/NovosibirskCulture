package com.culture_news.controller;

import com.culture_news.entity.Category;
import com.culture_news.entity.Place;
import com.culture_news.repositories.PlaceRepository;
import com.culture_news.service.NewsService;
import com.culture_news.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PlaceController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private PlaceService placeService;

    @GetMapping("/editor/addplace")
    public String placePage(Model model) {
        model.addAttribute("sidebarData", newsService.fourNewsList());
        model.addAttribute("place", new Place());
        model.addAttribute("category", new Category());
        return "addplace";
    }

    @PostMapping("/editor/addplace")
    public String addPlace(@ModelAttribute("place") Place place, @ModelAttribute("category") Category category, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("error", true);
            return "addplace";
        }

        if (!placeService.savePlace(place, category)) {
            model.addAttribute("addplaceError", true);
            return "addplace";
        }
        return "addplace";
    }

    @GetMapping("/music")
    public String musicPage(Model model){
        model.addAttribute("sidebarData", newsService.fourNewsList());
        model.addAttribute("places", placeService.categoryPlace("Музыка"));
        model.addAttribute("category", "music");
        return "categorylist";
    }
    @GetMapping("/music/{placeId}")
    public String musicList(@PathVariable Long placeId, Model model) {
        model.addAttribute("sidebarData", newsService.fourNewsList());
        model.addAttribute("place", placeRepository.getOne(placeId));
        return "category";
    }
    @GetMapping("/museums")
    public String museumPage(Model model){
        model.addAttribute("sidebarData", newsService.fourNewsList());
        model.addAttribute("places", placeService.categoryPlace("Музеи"));
        model.addAttribute("category", "museums");
        return "categorylist";

    }
    @GetMapping("/museums/{placeId}")
    public String museumList(@PathVariable Long placeId, Model model) {
        model.addAttribute("sidebarData", newsService.fourNewsList());
        model.addAttribute("place", placeRepository.getOne(placeId));
        return "category";
    }
    @GetMapping("/cinema")
    public String cinemaPage(Model model){
        model.addAttribute("sidebarData", newsService.fourNewsList());
        model.addAttribute("places", placeService.categoryPlace("Кино"));
        model.addAttribute("category", "cinema");
        return "categorylist";
    }
    @GetMapping("/cinema/{placeId}")
    public String cinemaList(@PathVariable Long placeId, Model model) {
        model.addAttribute("sidebarData", newsService.fourNewsList());
        model.addAttribute("place", placeRepository.getOne(placeId));
        return "category";
    }
    @GetMapping("/theaters")
    public String theatersPage(Model model) {
        model.addAttribute("sidebarData", newsService.fourNewsList());
        model.addAttribute("places", placeService.categoryPlace("Театры"));
        model.addAttribute("category", "theaters");
        return "categorylist";
    }
    @GetMapping("/theaters/{placeId}")
    public String theatersList(@PathVariable Long placeId, Model model) {
        model.addAttribute("sidebarData", newsService.fourNewsList());
        model.addAttribute("place", placeRepository.getOne(placeId));
        return "category";
    }

}