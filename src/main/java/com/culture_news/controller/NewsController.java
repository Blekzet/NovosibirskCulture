package com.culture_news.controller;

import com.culture_news.entity.Affiche;
import com.culture_news.entity.Category;
import com.culture_news.entity.Comments;
import com.culture_news.entity.News;
import com.culture_news.repositories.CommentsRepository;
import com.culture_news.repositories.NewsRepository;
import com.culture_news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private NewsService newsService;
    @Autowired
    private CommentsRepository commentsRepository;



    @GetMapping("/editor/addnews")
    public String addnewsPage(Model model) {
        model.addAttribute("sidebarData", newsService.fourNewsList());
        model.addAttribute("news", new News());
        model.addAttribute("category", new Category());
        return "addnews";
    }

    @PostMapping("/editor/addnews")
    public String addNews(@ModelAttribute("news") News news, @ModelAttribute("category") Category category, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("error", true);
            return "addnews";
        }

        if (!newsService.saveNews(news, category)) {
            model.addAttribute("addnewsError", true);
            return "addnews";
        }


        return "addnews";
    }

    @GetMapping("/news/{newsId}")
    public String newsPage(@PathVariable Long newsId, Model model) {
        model.addAttribute("sidebarData", newsService.fourNewsList());
        model.addAttribute("comments", commentsRepository.findByNewsId(newsId));
        model.addAttribute("saveComment", new Comments());
        model.addAttribute("news", newsRepository.getOne(newsId));
        return "news";
    }

    @GetMapping("/editor/changeNews/{newsId}")
    public String changeAffiche(@PathVariable Long newsId, Model model) {
        model.addAttribute("sidebarData", newsService.fourNewsList());
        model.addAttribute("news", newsRepository.getOne(newsId));
        return "changeNews";
    }

    @GetMapping("/editor/deleteNews/{newsId}")
    public String deleteAffiche(@PathVariable Long newsId, Model model) {
        newsService.deleteNews(newsRepository.getOne(newsId));
        return "/";
    }

    @PostMapping("/editor/changeNews/{newsId}")
    public String changeAfficheSave(@PathVariable Long newsId, @ModelAttribute("affiche") News news, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("error", true);
            return "changeNews";
        }

        if (!newsService.saveNewsChange(news, newsRepository.getOne(newsId))) {
            model.addAttribute("addError", true);
            return "changeNews";
        }

        return "redirect:/affiche/" + newsId;
    }


}
