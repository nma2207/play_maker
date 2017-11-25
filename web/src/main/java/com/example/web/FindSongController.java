package com.example.web;

import APIConnector.Connector;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pack.Singer;
import work.allWork;


import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Controller
public class FindSongController {

    @GetMapping("/")
    public ModelAndView index(){
        Map<String, String> model = new HashMap<>();
        model.put("name", "Marat");
        return new ModelAndView("index",model);
    }
    @RequestMapping(value ="/get_genre", method = RequestMethod.POST)
    public ModelAndView findSongForm(@RequestParam String singer, @RequestParam String song){
        Connector connector = new Connector(/* Список жанров в виде ArrayList на английском trance, pop, rock... */);
        String genre = "genre";
        try{
            genre = "";//connector.getGenre(singer, song);
        }
        catch (Exception e){
            genre = "Cannot find";
        }
        Map<String, String> map = new HashMap<>();

        Singer s = new Singer();
        s.setName_singer("Marat");
        Collection<Singer> s1;
        try {
             s1= allWork.getInstance().getSingerDAO().getAllSingers();


        }
        catch (Exception e){
            genre="bad";
        }
        map.put("genre", genre);
        return new ModelAndView("FindGenre",map);
    }
}
