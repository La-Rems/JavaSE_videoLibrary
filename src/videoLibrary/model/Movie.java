package videoLibrary.model;

import java.time.LocalDate;

// Classe "fille" qui hérite de la classe Media
public class Movie extends Media {
    // Attributs spécifiques à la classe fille
    private LocalDate releasedate;
    private Director director;
    private boolean viewed;

    /**
     * Constructeur de la classe qui surcharge le constructeur de Media
     * @param title
     * @param releasedate
     * @param director
     * @param viewed
     */
    public Movie(String title, LocalDate releasedate, Director director, boolean viewed) {
        super(title);
        this.releasedate = releasedate;
        this.director = director;
        this.viewed = viewed;
    }

    //Getter() et setter() de viewed uniquement pour savoir si le film a déjà été vu ou si l'utilisateur souhaite modifier sa valeur
    public boolean getViewed() {
        return viewed;
    }

    public void setViewed(boolean viewed) {
        this.viewed = viewed;
    }

    /**
     * @return l'objet Movie en string en rajoutant le toString() de la classe "mère" Media
     */
    @Override
    public String toString() {
        String media = super.toString();
        return " Film " + media +
                " date de sortie = " + releasedate +
                ", vu = " + viewed + ']'
                 + director;
    }
}
