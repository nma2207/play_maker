package simple;


import pack.Singer;
import work.allWork;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Driver;
import org.hibernate.SessionFactory;
import util.HibernateUtil;
import org.hibernate.Session;
import com.mysql.jdbc.Driver.*;
import APIConnector.Connector;
@WebServlet("/get_genre")
public class GetGenreServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String singerName = request.getParameter("singer_name");

        String song_name = request.getParameter("sing_name");
        Connector c = new Connector(/* Список жанров в виде ArrayList на английском trance, pop, rock... */);
        PrintWriter printWriter = response.getWriter();
        String res="";
        try {
            //res = c.getGenre(singerName, song_name);
            res = "Жанр";
            printWriter.println("<html><meta charset=\"UTF-8\"><body><h1>Жанр вашей песни:"+res+"</h1></body></html>");

        }
        catch(Exception e){
            //System.out.println("errors");
        }



    }



}
