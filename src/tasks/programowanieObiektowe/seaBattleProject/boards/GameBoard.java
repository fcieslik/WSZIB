package tasks.programowanieObiektowe.seaBattleProject.boards;

import tasks.programowanieObiektowe.seaBattleProject.units.ShipUnit;

import java.util.ArrayList;
import java.util.List;

public abstract class GameBoard {

    abstract GameField[][] setBoard();
    GameBoard() {
        addShipsToGame();
    }

    GameField[][] gameBoard = new GameField[20][20];
    List<ShipUnit> availableShips = new ArrayList<>();


    private void addShipsToGame() {
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 5 - i; j++) {
                availableShips.add(new ShipUnit(5, true, 100));
            }
        }
    }

    void deactivateBoard() {
        for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 20; j++) {
                gameBoard[i][j].setDisable(true);
            }
        }
    }

}
