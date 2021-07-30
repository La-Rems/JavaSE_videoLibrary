package videoLibrary.model;

import java.time.LocalDate;

public class Director {
    /**
     * Attributs de l'objet Réalisateur
     */
    private String lastname;
    private String firstname;
    private LocalDate birthAt;

    /**
     * Constructeur de l'objet Réalisateur
     * @param lastname
     * @param firstname
     * @param birthAt
     */
    public Director(String lastname, String firstname, LocalDate birthAt) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.birthAt = birthAt;
    }

    // Pas de getter() et setter() car pas l'utilité dans ce projet

    /**
     * @return l'objet Réalisateur en string
     */
    @Override
    public String toString() {
        return  " \n " +
                "    Réalisateur [" +
                " nom = '" + lastname + '\'' +
                ", prénom = '" + firstname + '\'' +
                ", date de naissance = " + birthAt +
                ']';
    }
}
