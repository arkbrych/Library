package library.app;

/**
 * @author Arkadiusz Brych
 * Program made during javastart.pl course
 */
public class LibraryApp {
    private static final String APP_NAME = "Biblioteka v1.2";

    public static void main(String[] args) {
        System.out.println(APP_NAME);
        LibraryControl libraryControl = new LibraryControl();
        libraryControl.controlLoop();
    }
}
