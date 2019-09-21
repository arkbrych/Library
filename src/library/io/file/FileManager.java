package library.io.file;

import library.model.Library;

// definiuje kontrakt, który polega na tym,
// że każdy menadżer plików w aplikacji (w sensie klasy implementującej ten interfejs),
// musi posiadać metody do importu oraz eksportu obiektu typu Library.
public interface FileManager {
    Library importData();
    void exportData(Library library);
}
