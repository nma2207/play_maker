package simple;

import pack2.Song;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/all_songs")
public class GetAllSongServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //String genre = request.getParameter("genre");
        List<Song> songsList = new ArrayList<Song>();
        for(int i=0;i <5;i++){
            Song s = new Song();
            s.setName("name_"+i);
            s.setGenre("genre_"+i);
            s.setSingerName("singer_"+i);
            s.setDurability("2."+i);
            songsList.add(s);

        }
        request.setAttribute("song_list", songsList);
        request.getRequestDispatcher("show_songs.jsp").forward(request, response);

    }
}
