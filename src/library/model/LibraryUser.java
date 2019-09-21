package library.model;

import java.util.ArrayList;
import java.util.List;

public class LibraryUser extends User {
    private List<Publication> publicationHistory = new ArrayList<>();
    private List<Publication> borrowedPublications = new ArrayList<>();

    public LibraryUser(String firstName, String lastName, String pesel) {
        super(firstName, lastName, pesel);
    }

    public List<Publication> getPublicationHistory() {
        return publicationHistory;
    }

    public List<Publication> getBorrowedPublications() {
        return borrowedPublications;
    }

    private void addPublicationToHistory(Publication pub) {
        publicationHistory.add(pub);
    }

    private void borrowedPublication(Publication pub) {
        borrowedPublications.add(pub);
    }

    public boolean returnPublication(Publication pub) {
        boolean result = false;
        if (borrowedPublications.remove(pub)) {
            result = true;
            addPublicationToHistory(pub);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        LibraryUser that = (LibraryUser) o;

        if (!publicationHistory.equals(that.publicationHistory)) return false;
        return borrowedPublications.equals(that.borrowedPublications);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + publicationHistory.hashCode();
        result = 31 * result + borrowedPublications.hashCode();
        return result;
    }

    @Override
    public String toCsv() {
        return getFirstName() + ";" + getLastName() + ";" + getPesel();
    }
}
