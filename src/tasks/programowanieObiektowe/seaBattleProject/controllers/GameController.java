package tasks.programowanieObiektowe.seaBattleProject.controllers;

import tasks.programowanieObiektowe.seaBattleProject.boards.GameField;
import tasks.programowanieObiektowe.seaBattleProject.boards.OponentBoard;
import tasks.programowanieObiektowe.seaBattleProject.boards.PlayerBoard;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class GameController {

    @FXML
    GridPane playerGrid = new GridPane();

    @FXML
    GridPane oponentGrid = new GridPane();

    @FXML
    Button startGameButton = new Button();

    private PlayerBoard player = new PlayerBoard();
    private OponentBoard computer = new OponentBoard();

    public void startGame() {
        startGameButton.setDisable(true);
        setGameGrids();
    }

   public void setGameGrids() {
        GameField[][] computerBoard = computer.setBoard();
        GameField[][] playerBoard = player.setBoard();
        for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 20; j++) {
                oponentGrid.add(computerBoard[i][j], i, j);
                playerGrid.add(playerBoard[i][j], i, j);
            }
        }
    }
}