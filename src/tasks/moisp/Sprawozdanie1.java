package tasks.moisp;

public class Sprawozdanie1 {

    public static void calculateFloatSequence(int number) {

        float x0 = 0.01f;
        float temp = 0.01f;
        System.out.println("Float: ");
        for (int i = 0; i < number; i++) {
            temp = x0 + 3.0f * x0 * (1 - x0);
            System.out.println(i + 1 + ": " + temp);
            x0 = temp;
        }
    }
}
