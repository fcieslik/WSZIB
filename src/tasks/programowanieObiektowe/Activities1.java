package tasks.programowanieObiektowe;

public class Activities1 {

    /*Task 1 - return true if only one number is between range of 13 and 19*/
    public boolean isTeen(int x, int y) {
        return (x >= 13 && x <= 19) != (y >= 13 && y <= 19);
    }

    /*Task 2 - return sum of 3 ints. If one of them is 13, skip it and the next value*/
    public int sumOf(int x, int y, int z) {
        if (x == 13) {
            return 0;
        }
        if (y == 13) {
            return y;
        }
        if (z == 13) {
            return (x + y);
        }
        return x + y + z;
    }

    /*Task 3 - find consecutive sequence in array*/
    public boolean isConsecutive(int[] arr) {
        for(int i=0; i < arr.length-2; i++){
            if (arr[i] == 1 && arr[i+1] == 2 && arr[i+2] == 3){
                return true;
            }
        }
        return false;
    }
}