package com.codeup.springblog.controllers;

import com.codeup.springblog.repositories.AdRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdController {

    private final AdRepository adDao;

    public AdController(AdRepository adDao) {
        this.adDao = adDao;
    }


    @GetMapping("/ads")
    public String allAds (Model model) {

        model.addAttribute("ads", adDao.findAll());

        return "ads/index";
    }

    @GetMapping("/ads/search")
    public String searchAdsByTitle (Model model) {

        return "ads/search";
    }

    @PostMapping("/ads/search")
    public String searchAdsByTitleResults (@RequestParam(name = "title") String title, Model model) {
        model.addAttribute("results", adDao.findAdByTitle(title));

        return "ads/search";
    }



}
