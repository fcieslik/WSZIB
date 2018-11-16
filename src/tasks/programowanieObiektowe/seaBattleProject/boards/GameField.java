package tasks.programowanieObiektowe.seaBattleProject.boards;
import javafx.scene.control.Button;

public class GameField extends Button {

    private int xAsis;
    private int yAsis;

    void setxAsis(int x) {
        this.xAsis = x;
    }

    void setyAsis(int yAsis) {
        this.yAsis = yAsis;
    }

    public int getxAsis() {
        return xAsis;
    }

    public int getyAsis() {
        return yAsis;
    }

    public void GameField (int x, int y) {
        this.xAsis = x;
        this.yAsis = y;

        this.setStyle("-fx-background-color: Blue;");
        this.setPrefSize(50, 50);
        this.setMinSize(50, 50);
        this.setMaxSize(50, 50);
    }
}
