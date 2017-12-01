package com.example.web.controller;

import APIConnector.Connector;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pack.Genre;
import pack.Singer;
import work.allWork;


import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Controller
public class GetGenreController {
    @GetMapping("/")
    public ModelAndView index(){
        Map<String, String> model = new HashMap<>();
        model.put("name", "Marat");
        return new ModelAndView("index",model);
    }
    @RequestMapping(value ="/get_genre", method = RequestMethod.POST)
    public ModelAndView findSongForm(@RequestParam String singer, @RequestParam String song){
        Connector connector = new Connector(/* Список жанров в виде ArrayList на английском trance, pop, rock... */);
        String genreType = "genre";
        try{
            genreType = connector.getGenre(singer, song);
        }
        catch (Exception e){
            genreType = "Cannot find";
        }
        Map<String, String> map = new HashMap<>();
        Genre genre = new Genre();
        genre.setIdgenre(1);
        genre.setName_genre(genreType);
        Collection songsList=null;
        try {
            songsList = allWork.getInstance().getSongsDAO().getSongsByName("Strobe");
        }
        catch (Exception e){
            genreType="error";
        }
        map.put("genre", genreType);

        return new ModelAndView("FindGenre",map);

    }
}
