package tasks.programowanieObiektowe.seaBattleProject.boards;

import javafx.scene.input.MouseEvent;

public class OponentBoard extends GameBoard {

    private void checkField(GameField source) {
    }

    public GameField[][] setBoard() {
        for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 20; j++) {
                super.gameBoard[i][j] = new GameField();
                super.gameBoard[i][j].addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                    checkField((GameField)event.getSource());
                });
            }
        }
        deactivateBoard();
        return super.gameBoard;
    }
}