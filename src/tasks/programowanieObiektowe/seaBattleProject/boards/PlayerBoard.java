package tasks.programowanieObiektowe.seaBattleProject.boards;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class PlayerBoard extends GameBoard{
    private int shipNumber = 0;

    public GameField[][] setBoard() {

        for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 19; j++) {
                gameBoard[i][j] = new GameField();
                gameBoard[i][j].addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                    if (event.getButton() == MouseButton.PRIMARY) {
                        addShipVerticallyToBoard((GameField)event.getSource());
                    } else if(event.getButton() == MouseButton.SECONDARY) {
                        addShipHorizontallyToBoard((GameField)event.getSource());
                    }
                });
            }
        }
        return super.gameBoard;
    }

    private void addShipHorizontallyToBoard(GameField source) {
        GameField field;
        for (int i = 0; i < availableShips.size(); i++) {
            field = gameBoard[source.getxAsis() + i][source.getxAsis()];
            field.setDisable(true);
            field.setStyle("-fx-background-color: Red;");

        }
        if (shipNumber == 9) {
            super.deactivateBoard();
        }
        shipNumber++;
    }

    private void addShipVerticallyToBoard(GameField source) {
        GameField field;
        for (int i = 0; i < availableShips.size(); i++) {
            field = gameBoard[source.getxAsis()][source.getyAsis() + i];
            field.setDisable(true);
            field.setStyle("-fx-background-color: Red;");

        }
        if (shipNumber == 9) {
            super.deactivateBoard();
        }
        shipNumber++;
    }
}