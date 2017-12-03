package com.example.web.controller;

import APIConnector.Connector;
import converter.Converter;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pack.Genre;
import pack.Singer;
import pack.Songs;


import java.lang.reflect.Field;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import work.allWork;

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
        Connector connector = new Connector();
        String genreType = "";
        try{
            genreType = connector.getGenre(singer, song);
        }
        catch (Exception e){
        }
        Map<String, String> map = new HashMap<>();
        Genre genre = new Genre();
        genre.setIdgenre(1);
        genre.setName_genre(genreType);
        Collection songsList=null;
        try {
            songsList = allWork.getSongsDAO().getSongsByGenre(genre);



        }
        catch (Exception e){
            genreType="error";
        }
        ArrayList<Songs> songs=Converter.songConvert(songsList);
        map.put("genre", genreType);

        return new ModelAndView("FindGenre",map);

    }
}
