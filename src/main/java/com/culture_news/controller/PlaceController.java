package com.culture_news.controller;

import com.culture_news.entity.*;
import com.culture_news.repositories.CategoryRepository;
import com.culture_news.repositories.CommentsRepository;
import com.culture_news.repositories.NewsRepository;
import com.culture_news.repositories.PlaceRepository;
import com.culture_news.service.NewsService;
import com.culture_news.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PlaceController {

    @Autowired
    private NewsService newsService;
    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PlaceService placeService;

    @GetMapping("/editor/addplace")
    public String placePage(Model model) {
        model.addAttribute("sidebarData", newsService.fourNewsList());
        model.addAttribute("place", new Place());
        model.addAttribute("category", new Category());
        return "addplace";
    }

    @GetMapping("/editor/deletePlace/{placeId}")
    public String deletePerson(@PathVariable Long placeId, Model model) {
        placeService.deletePlace(placeRepository.getOne(placeId));
        return "index";
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

    @GetMapping("/editor/changePlace/{placeId}")
    public String changePlace(@PathVariable Long placeId, Model model) {
        model.addAttribute("sidebarData", newsService.fourNewsList());
        model.addAttribute("place", placeRepository.getOne(placeId));
        return "changePlace";
    }


    @PostMapping("/editor/changePlace/{placeId}")
    public String changePlaceSave(@PathVariable Long placeId, @ModelAttribute("place") Place place, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("error", true);
            return "changePlace";
        }

        if (!placeService.savePlaceChange(place, placeId)) {
            model.addAttribute("addError", true);
            return "changePlace";
        }

        return "redirect:/place/" + placeId;
    }

    public Model setPlaceList(Long placeId, Model model){
        model.addAttribute("sidebarData", newsService.fourNewsList());
        model.addAttribute("place", placeRepository.getOne(placeId));
        return model;
    }

    @GetMapping("/{categoryName}")
    public String musicPage(@PathVariable String categoryName, Model model){
        Category category = categoryRepository.findByEngName(categoryName);

        model.addAttribute("sidebarData", newsService.fourNewsList());
        model.addAttribute(category.getName(), placeService.categoryPlace(category.getName()));
        model.addAttribute("category", category.getName());
        return "categorylist";
    }
    @GetMapping("/music/{placeId}")
    public String musicList(@PathVariable Long placeId, Model model) {
        model = setPlaceList(placeId, model);
        return "category";
    }

    @GetMapping("categoryNews/{category}/")
    public String categoryNewsPage(@PathVariable String category, Model model, HttpServletRequest request){
        int page = 0;
        int size = 12;

        Category currentCategory = categoryRepository.findByEngName(category);

        if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
            page = Integer.parseInt(request.getParameter("page")) - 1;
        }

        model.addAttribute("newsList", newsRepository.findByNewsCategory(currentCategory.getName(), PageRequest.of(page, size)));
        model.addAttribute("sidebarData", newsService.fourNewsList());
        return "categoryNews";
    }

    @PostMapping("categoryNews/{category}/")
    public String rootCategoryChange(@PathVariable String category, Model model){
        int page = 0;
        int size = 12;

        Category currentCategory = categoryRepository.findByEngName(category);

        model.addAttribute("newsList", newsRepository.findByNewsCategory(currentCategory.getName(), PageRequest.of(page, size)));
        model.addAttribute("sidebarData", newsService.fourNewsList());
        return "categoryNews";
    }

}
