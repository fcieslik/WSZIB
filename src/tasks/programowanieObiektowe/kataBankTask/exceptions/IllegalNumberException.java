package tasks.programowanieObiektowe.kataBankTask.exceptions;

public class IllegalNumberException extends Exception {

    public IllegalNumberException(String message) {
        super("Illegal Number exception has been thrown: " + message);
    }
}
