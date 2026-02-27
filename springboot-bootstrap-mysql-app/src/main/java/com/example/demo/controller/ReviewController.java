package com.example.demo.controller;

import com.example.demo.model.Review;
import com.example.demo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("review", new Review());
        return "form";
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute Review review) {
        reviewRepository.save(review);
        return "success";
    }
}
