package ua.lviv.lgs;

@SuppressWarnings("serial")
public class WrongInputException extends Throwable {
    WrongInputException() {
        System.err.println("This fraction doesn't exists!");
    }
}