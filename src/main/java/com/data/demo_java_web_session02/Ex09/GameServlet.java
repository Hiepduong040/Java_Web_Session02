package com.data.demo_java_web_session02.Ex09;

import com.data.demo_java_web_session02.Ex09.WordGame;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "GameServlet", value = "/game")
public class GameServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public GameServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        WordGame game = (WordGame) session.getAttribute("game");

        // Neu chua co game hoac co yeu cau bat dau moi
        String newGame = request.getParameter("newGame");
        if (game == null || "true".equals(newGame)) {
            game = new WordGame();
            session.setAttribute("game", game);
        }

        // Chuyen den trang JSP
        request.getRequestDispatcher("/game.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        WordGame game = (WordGame) session.getAttribute("game");

        // Neu game chua duoc tao
        if (game == null) {
            game = new WordGame();
            session.setAttribute("game", game);
        }

        // Lay tham so doan tu request
        String guess = request.getParameter("guess");

        // Thuc hien doan
        if (guess != null && !guess.trim().isEmpty()) {
            if (guess.length() == 1) {
                // Doan chu cai
                game.guessLetter(guess.charAt(0));
            } else {
                // Doan ca tu
                game.guessWord(guess);
            }
        }

        // Chuyen den trang JSP
        request.getRequestDispatcher("/game.jsp").forward(request, response);
    }
}
