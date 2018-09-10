package controllers;

import models.MovieCompany;
import models.TheaterLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import repositories.MovieCompanyRepository;
import repositories.TheaterLocationRepository;

import java.util.List;

@Controller
@RequestMapping
public class HomePageController {
    @Autowired
    MovieCompanyRepository movieCompanyRepository;

    @Autowired
    TheaterLocationRepository theaterLocationRepository;

    @RequestMapping
    public String homepage(Model model) {
        List<MovieCompany> companies = movieCompanyRepository.findAll();
        List<TheaterLocation> theaters = theaterLocationRepository.findAll();

        model.addAttribute("companies", companies);
        model.addAttribute("theaters", theaters);

        return "index";
    }
}