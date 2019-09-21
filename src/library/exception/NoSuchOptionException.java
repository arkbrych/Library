package library.exception;

// obsługuje wyjątek gdy w type Option zostanie nie podany poprawny int
public class NoSuchOptionException extends Exception {
    public NoSuchOptionException(String message){
        super(message);
    }
}
