package videoLibrary.service.action;

public enum VideothequeActions {
    LIST_ALL_MOVIES("1", "Lister les films"),
    ADD_FILM("2", "Ajouter un film"),
    DELETE_FILM("3", "Supprimer un film"),
    SEE_FILM_TRUE("4", "Marquer un film comme vu"),
    MODIFY_FILM("5", "Modifier le titre d’un film"),
    LIST_FILM_NOT_SEE("6", "Lister les films non-vus"),
    LIST_FILM_SEE("7", "Lister les films vus"),
    SORT_TITLE("8", "Trier les films par ordre alphabétique (basé sur le titre)"),
    EXIT("0", "Quitter");

    private String value;
    private String title;

    VideothequeActions(String value, String title) {
        this.value = value;
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public String getTitle() {
        return title;
    }

    public static boolean containsAction(String value) {
        videoLibrary.service.action.VideothequeActions[] actions = videoLibrary.service.action.VideothequeActions.values();

        for (videoLibrary.service.action.VideothequeActions action : actions) {
            if (action.getValue().equalsIgnoreCase(value)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return value + " - " + title;
    }
}
