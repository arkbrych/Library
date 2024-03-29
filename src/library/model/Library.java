package library.model;

import library.exception.PublicationAlreadyExistsException;
import library.exception.UserAlreadyExistsException;

import java.io.Serializable;
import java.util.*;

// przechowywanie informacji o książkach
public class Library implements Serializable {

    private Map<String, Publication> publications = new HashMap<>();
    private Map<String, LibraryUser> users = new HashMap<>();

    public Optional<Publication> findPublicationByTitle(String title){
        return Optional.ofNullable(publications.get(title));
    }

    public Map<String, Publication> getPublications() {
        return publications;
    }

    public Map<String, LibraryUser> getUsers() {
        return users;
    }

    public Collection<Publication> getSortedPublications(Comparator<Publication> comparator){
        ArrayList<Publication> list = new ArrayList<>(this.publications.values());
        list.sort(comparator);
        return list;
    }

    public Collection<LibraryUser> getSortedUsers(Comparator<LibraryUser> comparator){
        ArrayList<LibraryUser> list = new ArrayList<>(this.users.values());
        list.sort(comparator);
        return list;
    }

    //dodania metoda i rzucany nowy typ wyjątku
    public void addUser(LibraryUser user) {
        if (users.containsKey(user.getPesel()))
            throw new UserAlreadyExistsException(
                    "Użytkownik ze wskazanym peselem już istnieje" + user.getPesel()
            );
        users.put(user.getPesel(), user);
    }

    //zmieniona logika
    public void addPublication(Publication publication) {
        if (publications.containsKey(publication.getTitle()))
            throw new PublicationAlreadyExistsException(
                    "Publikacja o takim tytule już istnieje" + publication.getTitle()
            );
        publications.put(publication.getTitle(), publication);
    }

    //zmieniona logika
    public boolean removePublication(Publication publication) {
        if (publications.containsValue(publication)) {
            publications.remove(publication.getTitle());
            return true;
        } else {
            return false;
        }
    }
}
