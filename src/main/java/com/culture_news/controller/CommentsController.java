package com.culture_news.controller;

import com.culture_news.entity.Comments;
import com.culture_news.entity.News;
import com.culture_news.entity.User;
import com.culture_news.repositories.CommentsRepository;
import com.culture_news.repositories.UserRepository;
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

    @PostMapping("/comment/news/{newsId}")
    public String saveNewsComment(@PathVariable Long newsId, @ModelAttribute("saveComment") Comments comment, Model model, HttpServletRequest request, Principal principal){
        comment.setNewsId(newsId);
        User user = userRepository.findByUserName(principal.getName());
        comment.setUserId(user.getUserId());
        comment.setUserName(user.getUserName());
        commentsRepository.save(comment);
        return "redirect:" + request.getHeader("referer");
    }
    @PostMapping("/comment/place/{placeId}")
    public String savePlaceComment(@PathVariable Long placeId, @ModelAttribute("saveComment") Comments comment, Model model, HttpServletRequest request, Principal principal){
        comment.setPlaceId(placeId);
        User user = userRepository.findByUserName(principal.getName());
        comment.setUserId(user.getUserId());
        comment.setUserName(user.getUserName());
        commentsRepository.save(comment);
        return "redirect:" + request.getHeader("referer");
    }
    @PostMapping("/comment/affiche/{afficheId}")
    public String saveAfficheComment(@PathVariable Long afficheId, @ModelAttribute("saveComment") Comments comment, Model model, HttpServletRequest request, Principal principal){
        comment.setAfficheId(afficheId);
        User user = userRepository.findByUserName(principal.getName());
        comment.setUserId(user.getUserId());
        comment.setUserName(user.getUserName());
        commentsRepository.save(comment);
        return "redirect:" + request.getHeader("referer");
    }
    @PostMapping("/comment/person/{personId}")
    public String savePersonComment(@PathVariable Long personId, @ModelAttribute("saveComment") Comments comment, Model model, HttpServletRequest request, Principal principal){
        comment.setPersonId(personId);
        User user = userRepository.findByUserName(principal.getName());
        comment.setUserId(user.getUserId());
        comment.setUserName(user.getUserName());
        commentsRepository.save(comment);
        return "redirect:" + request.getHeader("referer");
    }
}
