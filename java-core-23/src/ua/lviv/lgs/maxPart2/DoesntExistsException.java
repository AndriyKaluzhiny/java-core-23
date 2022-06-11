package ua.lviv.lgs.maxPart2;

public class DoesntExistsException extends Throwable {
    DoesntExistsException() {
        System.err.println("This product doesn't exists!");
    }
}