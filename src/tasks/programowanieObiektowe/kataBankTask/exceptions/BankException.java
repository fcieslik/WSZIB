package tasks.programowanieObiektowe.kataBankTask.exceptions;

public class BankException extends RuntimeException {

    public BankException(){
    }

    public BankException(String message){
        super("Bank exception has been thrown: " + message);
    }

    public BankException(Throwable throwable) {
        super(throwable);
    }
}
