package com.example.web.controller;

import APIConnector.Connector;
//import org.hibernate.mapping.Collection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pack.Genre;
import pack.Singer;
import pack.Songs;


import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

public class FindController {
//    @RequestMapping(value ="/get_gen", method = RequestMethod.POST)
//    public ModelAndView findSongForm(@RequestParam String what, @RequestParam String by){
//
//        Map<String, String> map = new HashMap<>();
//        Collection<Songs> songsList;
//        if(by.equals("Жанр")){
//            Genre genre = new Genre();
//            genre.setName_genre(what);
//            try {
//                songsList = allWork.getSongsDAO().getSongsByGenre(genre);
//            }
//            catch (Exception e){}
//        }
//
//        if(by.equals("Исполнитель")){
//            Singer singer =new Singer();
//            singer.setName_singer(what);
//            try {
//                songsList = allWork.getSongsDAO().getSongsBySinger(singer);
//            }
//            catch (Exception e){}
//        }
//
//        if(by.equals("Название")){
//            try {
//                songsList = allWork.getSongsDAO().getSongsByName(by);
//            }
//            catch (Exception e){}
//        }
//        return new ModelAndView("FindGenre",map);
//
//    }
}
