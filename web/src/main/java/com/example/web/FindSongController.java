package com.example.web;
import APIConnector.Connector;
import com.sun.javafx.scene.layout.region.Margins;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pack.Singer;
import work.allWork;
import javax.swing.text.html.parser.Parser;
import java.util.*;

@Controller
public class FindSongController {

    @GetMapping("/")
    public ModelAndView index(){
        Map<String, String> model = new HashMap<>();
        model.put("name", "Marat");
        return new ModelAndView("index",model);
    }
    /*@RequestMapping("/")
    public String homePage(@RequestParam("name") String name, Model model){
        name = "Igor";
        model.addAttribute("name", name);
        return "home";
    }*/
    @RequestMapping(value ="/get_genre", method = RequestMethod.POST)
    public ModelAndView findSongForm(@RequestParam String singer, @RequestParam String song){
        Connector connector = new Connector(/* Список жанров в виде ArrayList на английском trance, pop, rock... */);
        String genre = "Answer";
        try{
            genre = connector.getGenre(singer, song);//connector.getGenre(singer, song);
        }
        catch (Exception e){
            genre = "Cannot find";
        }
        Map<String, String> map = new HashMap<>();

        Singer s = new Singer();
        //s.setName_singer("Marat");
        //s.setIdsinger(2);
        //Collection<Singer> s1;
        //try {
        //     allWork.getInstance().getSingerDAO().addSinger(s);
        //}
        //catch (Exception e){
        //    genre="bad";
        // }
        map.put("genre", genre);
        return new ModelAndView("FindGenre",map);
    }
    @RequestMapping(value ="/get_all", method = RequestMethod.POST)
    public ModelAndView findAllForm(@RequestParam String singer, @RequestParam String song){
        String genre = "Answer";
        Connector connector = new Connector(/* Список жанров в виде ArrayList на английском trance, pop, rock... */);
        Map<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<String>(); // Тут надо заменить на getSinger()
        list.add("dead");
        list.add("mau5");
        try {
            genre = connector.getGenre(singer, song);
        }
        catch (Exception e){
            genre="bad";
        }
        map.put("list", list);
        return new ModelAndView("FindAll", map);
    }
    /*@RequestMapping(value = "/get_all" , method = RequestMethod.POST)
    @ModelAttribute("list")
    public ArrayList<String> getuser()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("dead");
        list.add("mau5");
        return  list;
    }*/
}
