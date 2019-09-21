package library.exception;

// rzuca błąd gdy plik się znajduje, ale jest uszkodzony
public class InvalidDataException extends RuntimeException {
    public InvalidDataException(String message){
        super(message);
    }
}
