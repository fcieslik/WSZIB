package tasks.programowanieObiektowe.seaBattleProject.units;

public class ShipUnit {

    private int healthValue;
    private int shipSize;
    private boolean verticalPosition = true;

    public ShipUnit(int size, boolean verticalPosition, int healthValue) {
        this.shipSize = size;
        this.verticalPosition = verticalPosition;
        this.healthValue = healthValue;
    }

    int getShipSize() {
        return this.shipSize;
    }
}
