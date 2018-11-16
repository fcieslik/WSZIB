package tasks.programowanieObiektowe.seaBattleProject.boards;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class PlayerBoard extends GameBoard{
    private int currentShips = 0;

    public GameField[][] setBoard() {
        for(int x = 0; x < 20; x++) {
            for(int y = 0; y < 19; y++) {
                gameBoard[x][y] = new GameField();
                gameBoard[x][y].addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
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

        for (int x = 0; x < availableShips.size(); x++) {
            field = gameBoard[source.getxAsis() + x][source.getxAsis()];
            field.setDisable(true);
            field.setStyle("-fx-background-color: Red;");
        }

        if (currentShips == 9) {
            super.deactivateBoard();
        }
        currentShips++;
    }

    private void addShipVerticallyToBoard(GameField source) {
        GameField field;

        for (int x = 0; x < availableShips.size(); x++) {
            field = gameBoard[source.getxAsis()][source.getyAsis() + x];
            field.setDisable(true);
            field.setStyle("-fx-background-color: Red;");
        }

        if (currentShips == 9) {
            super.deactivateBoard();
        }
        currentShips++;
    }
}