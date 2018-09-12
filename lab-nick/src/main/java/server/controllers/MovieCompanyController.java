package server.controllers;

import server.models.MovieCompany;
import server.models.TheaterLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import server.repositories.MovieCompanyRepository;
import server.repositories.TheaterLocationRepository;


@Controller
@RequestMapping("/moviecompanies")
public class MovieCompanyController {
    @Autowired
    MovieCompanyRepository movieCompanyRepository;

    @Autowired
    TheaterLocationRepository theaterLocationRepository;

    @PostMapping
    public String createMovieCompany(@RequestParam String name) {
        MovieCompany company = movieCompanyRepository.save(new MovieCompany(name));
        System.out.println(name);
        return "redirect:/";
    }

    @PostMapping("add-location")
    public String addTheaterLocation(
            @RequestParam long companyid,
            @RequestParam String locationName,
            @RequestParam String address
    )
    {
        TheaterLocation theater = theaterLocationRepository.save(new TheaterLocation(companyid, locationName, address));
        System.out.println("Succesfully hit add-location controller");
        System.out.println(companyid);
        System.out.println(locationName);
        System.out.println(address);
        return "redirect:/";
    }
}