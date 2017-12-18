package com.example.web.controller;

import APIConnector.Connector;
//import org.hibernate.mapping.Collection;
import converter.Converter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pack.Genre;
import pack.Singer;
import pack.Song;
import pack.Songs;
import work.allWork;


import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;
@Controller
public class FindController {
    @RequestMapping(value ="/get_all", method = RequestMethod.POST)
    public ModelAndView findSongForm( @RequestParam String what, @RequestParam String by){
        Collection<Songs> songsList=null;
        if(by.equals("Genre")){
            Genre genre = new Genre();
            genre.setName_genre(what);
            try {
                songsList = allWork.getSongsDAO().getSongsByGenre(genre);
            }
            catch (Exception e){}
        }

        if(by.equals("Artist")){
            Singer singer =new Singer();
            singer.setName_singer(what);
            try {
                songsList = allWork.getSongsDAO().getSongsBySinger(singer);
            }
            catch (Exception e){}
        }

        if(by.equals("Song")){
            try {
                songsList = allWork.getSongsDAO().getSongsByName(what);
            }
            catch (Exception e){}
        }
        ArrayList<Songs> songs= Converter.songConvert(songsList);
        ArrayList<Singer> singers=new ArrayList<>();
        try{
            singers=Converter.singerConvert(allWork.getSingerDAO().getAllSingers());
        }
        catch (Exception e){}

        ArrayList<Song> newSongs = Converter.getSongsWithArtist(singers, songs);




        ModelAndView res = new ModelAndView("FindAll");
        res.addObject("list", newSongs);

        return res;

    }
}
