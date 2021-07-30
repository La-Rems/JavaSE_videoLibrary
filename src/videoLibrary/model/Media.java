package videoLibrary.model;

/**
 * Classe abstract -> "mère"
 */
public abstract class Media {
    private String title;

    /**
     * Constructeur de l'objet Media
     * @param title
     */
    public Media(String title) {
        this.title = title;
    }

    // Getter() pour utile pour comparer si le film existe etc..
    // Setter() pour laisser la possibilité à l'utilisateur de modifier le titre d'un film

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return l'objet Media en string
     */
    @Override
    public String toString() {
        return "[" +
                " titre ='" + title + '\'';
    }
}
