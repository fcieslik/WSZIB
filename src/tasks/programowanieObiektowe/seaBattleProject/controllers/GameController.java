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
        setGrids();
    }

   public void setGrids() {
        GameField[][] playerBoard = player.setBoard();
        GameField[][] computerBoard = computer.setBoard();
        for(int x = 0; x < 20; x++) {
            for(int y = 0; y < 20; y++) {
                playerGrid.add(playerBoard[x][y], x, y);
                oponentGrid.add(computerBoard[x][y], x, y);
            }
        }
    }
}