<%@ page import="com.data.demo_java_web_session02" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Game Doan Tu</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f2f5;
            color: #333;
            line-height: 1.6;
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }
        .container {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            padding: 30px;
            text-align: center;
        }
        h1 {
            color: #4267B2;
            margin-bottom: 20px;
        }
        .word-display {
            font-size: 36px;
            font-weight: bold;
            letter-spacing: 5px;
            margin: 30px 0;
        }
        .game-info {
            margin: 20px 0;
            font-size: 18px;
        }
        .incorrect-guesses {
            color: #e74c3c;
            font-weight: bold;
        }
        .tries-left {
            color: #3498db;
            font-weight: bold;
        }
        .guess-form {
            margin: 30px 0;
        }
        input[type="text"] {
            padding: 10px;
            font-size: 16px;
            border: 2px solid #ddd;
            border-radius: 4px;
            width: 60%;
            max-width: 300px;
        }
        button {
            padding: 10px 20px;
            font-size: 16px;
            background-color: #4267B2;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin: 10px;
            transition: background-color 0.3s;
        }
        button:hover {
            background-color: #365899;
        }
        .message {
            font-size: 24px;
            font-weight: bold;
            margin: 20px 0;
        }
        .win {
            color: #2ecc71;
        }
        .lose {
            color: #e74c3c;
        }
        .hangman {
            width: 200px;
            height: 200px;
            margin: 0 auto;
            position: relative;
        }
        .hangman img {
            width: 100%;
        }
    </style>
</head>
<body>
<%
    WordGame game = (WordGame) session.getAttribute("game");
    if (game == null) {
        game = new WordGame();
        session.setAttribute("game", game);
    }

    String guessedLettersDisplay = game.getGuessedLettersDisplay();
    String incorrectGuessesDisplay = game.getIncorrectGuessesDisplay();
    int triesLeft = game.getTriesLeft();
    boolean gameOver = game.isGameOver();
    boolean gameWon = game.isGameWon();
    String secretWord = game.getSecretWord();
    int hangmanState = game.getHangmanState();
%>

<div class="container">
    <h1>Game Doan Tu</h1>

    <div class="game-info">
        <p>Hay doan tu bi mat bang cach nhap mot chu cai hoac tu day du.</p>
        <p class="tries-left">So lan doan sai con lai: <%= triesLeft %></p>

        <% if (!incorrectGuessesDisplay.isEmpty()) { %>
        <p class="incorrect-guesses">
            Chu cai doan sai: <%= incorrectGuessesDisplay %>
        </p>
        <% } %>
    </div>

    <div class="hangman">
    <pre>
           <%
               if (hangmanState == 0) {
           %>
        +---+
        |   |
            |
            |
            |
            |
        ========
            <%
            } else if (hangmanState == 1) {
            %>
        +---+
        |   |
        O   |
            |
            |
            |
        ========
            <%
            } else if (hangmanState == 2) {
            %>
        +---+
        |   |
        O   |
        |   |
            |
            |
        ========
            <%
            } else if (hangmanState == 3) {
            %>
        +---+
        |   |
        O   |
        /|  |
            |
            |
        ========
            <%
            } else if (hangmanState == 4) {
            %>
        +---+
        |   |
        O   |
        /|\ |
            |
            |
        ========
            <%
            } else if (hangmanState == 5) {
            %>
        +---+
        |   |
        O   |
        /|\ |
        /    |
             |
        ========
            <%
            } else if (hangmanState == 6) {
            %>
        +---+
        |   |
        O   |
        /|\ |
        / \ |
             |
        ========
    <%
        }
    %>
            </pre>
    </div>

    <div class="word-display">
        <%= guessedLettersDisplay %>
    </div>

    <% if (gameOver) { %>
    <% if (gameWon) { %>
    <div class="message win">Chuc mung! Ban da doan dung tu!</div>
    <% } else { %>
    <div class="message lose">
        Rat tiec! Ban da thua.<br>
        Tu bi mat la: <%= secretWord %>
    </div>
    <% } %>

    <form action="game" method="get">
        <input type="hidden" name="newGame" value="true">
        <button type="submit">Choi lai</button>
    </form>
    <% } else { %>
    <form class="guess-form" action="game" method="post">
        <input type="text" name="guess" maxlength="20" placeholder="Nhap chu cai hoac tu..." required autofocus>
        <button type="submit">Doan</button>
    </form>
    <% } %>
</div>
</body>
</html>
