package com.culture_news.controller;

import com.culture_news.entity.Comments;
import com.culture_news.entity.News;
import com.culture_news.entity.User;
import com.culture_news.repositories.*;
import com.culture_news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class CommentsController {
    @Autowired
    private CommentsRepository commentsRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AfficheRepository afficheRepository;
    @Autowired
    private NewsRepository newsRepository;

    @PostMapping("/comment/news/{newsId}")
    public String saveNewsComment(@PathVariable Long newsId, @ModelAttribute("saveComment") Comments comment, Model model, HttpServletRequest request, Principal principal){
        comment.setNewsId(newsId);
        newsRepository.getOne(newsId).setCommentsCount(1L);
        User user = userRepository.findByUserName(principal.getName());
        comment.setUserName(user.getUserName());
        commentsRepository.save(comment);
        return "redirect:" + request.getHeader("referer");
    }
    @PostMapping("/comment/affiche/{afficheId}")
    public String saveAfficheComment(@PathVariable Long afficheId, @ModelAttribute("saveComment") Comments comment, Model model, HttpServletRequest request, Principal principal){
        comment.setAfficheId(afficheId);
        afficheRepository.getOne(afficheId).setCommentCount(1L);
        User user = userRepository.findByUserName(principal.getName());
        comment.setUserName(user.getUserName());
        commentsRepository.save(comment);
        return "redirect:" + request.getHeader("referer");
    }
}
