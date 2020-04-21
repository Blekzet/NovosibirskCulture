package com.culture_news.controller;

import com.culture_news.entity.Category;
import com.culture_news.entity.News;
import com.culture_news.repositories.CategoryRepository;
import com.culture_news.repositories.NewsRepository;
import com.culture_news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class HomeController {
    @Autowired
    private NewsService newsService;
    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    @GetMapping("/")
    public String rootPage(Model model, HttpServletRequest request) {
        int page = 0;
        int size = 12;


        if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
            page = Integer.parseInt(request.getParameter("page")) - 1;
        }

        model.addAttribute("newsList", newsRepository.findAll(PageRequest.of(page, size)));
        model.addAttribute("category", new Category());
        model.addAttribute("sidebarData", newsService.fourNewsList());
        return "index";
    }

    @PostMapping("/")
    public String rootCategoryChange(Model model, @ModelAttribute("category") Category category){
        int page = 0;
        int size = 12;

        if(category.getName().equals("All")){
            model.addAttribute("newsList", newsRepository.findAll(PageRequest.of(page, size)));
        }
        else{
            model.addAttribute("newsList", newsRepository.findByNewsCategory(category.getName(), PageRequest.of(page, size)));
        }

        model.addAttribute("category", category);
        model.addAttribute("sidebarData", newsService.fourNewsList());
        return "index";
    }



}
