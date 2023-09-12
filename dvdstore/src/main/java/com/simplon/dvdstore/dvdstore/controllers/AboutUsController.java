package com.simplon.dvdstore.dvdstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class AboutUsController {


    @RequestMapping(value ="/about-us", method = RequestMethod.GET)
    public String displayFullDetails(){
        System.out.println("tentative d'affichage de l'a-propos");
        return""; // Possibilité de retourner une vue, page HTML, appro
    }
}
