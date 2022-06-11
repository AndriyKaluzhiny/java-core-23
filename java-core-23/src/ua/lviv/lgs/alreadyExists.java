package ua.lviv.lgs;

@SuppressWarnings("serial")
public class alreadyExists extends Throwable {
    alreadyExists() {
        System.err.println("This deputy already exists");
    }
}