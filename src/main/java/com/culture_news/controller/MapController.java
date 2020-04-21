package com.culture_news.controller;

import com.culture_news.entity.News;
import com.culture_news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {
    @Autowired
    private NewsService newsService;

    @GetMapping("/landmark")
    public String mapPage(Model model) {
        model.addAttribute("sidebarData", newsService.fourNewsList());
        return "map";
    }
}
