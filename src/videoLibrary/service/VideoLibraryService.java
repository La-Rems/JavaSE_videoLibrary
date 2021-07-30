package videoLibrary.service;

import videoLibrary.model.Director;
import videoLibrary.model.Movie;
import videoLibrary.service.action.VideothequeActions;
import videoLibrary.utils.ConsoleManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class VideoLibraryService extends RunnableServiceAbstractImpl {

    private List<Movie> movieList;

    /**
     * Constructeur qui initalise la liste "movieList" et ajoute des données fictives pour le test
     */
    public VideoLibraryService() {
        this.movieList = new ArrayList<>();
        movieList.add(new Movie("Thor", LocalDate.of(1998, 2, 13), new Director("Fiurty", "Youan", LocalDate.of(1998, 5, 5)), false));
        movieList.add(new Movie("Titanic", LocalDate.of(1998, 2, 13), new Director("Bonnabaud", "Rémi", LocalDate.of(1998, 5, 5)), false));
        movieList.add(new Movie("Avengers", LocalDate.of(2015, 7, 25), new Director("Dupont", "Eric", LocalDate.of(1998, 5, 5)), true));
        movieList.add(new Movie("Spider-man", LocalDate.of(2018, 2, 13), new Director("Fatria", "Didier", LocalDate.of(1998, 5, 5)), true));
        movieList.add(new Movie("Interstellar", LocalDate.of(2005, 2, 13), new Director("Auvit", "Jules", LocalDate.of(1998, 5, 5)), false));
    }

    /**
     * Méthode run() pour lancer le projet avec le menu
     */
    public void run() {
        printTitle("##    Bienvenue sur ma Videotheque    ##");
        String answer;

        do {
            answer = printMenu(VideothequeActions.values());
            ConsoleManager.getInstance().consoleLineBreak();
            handleAction(answer);
        } while (!answer.equalsIgnoreCase("0"));
    }

    /**
     * Suite de condition qui déclenche une méthode suivant le choix de l'utilisateur
     */
    private void handleAction(String answer) {

        if (answer.equalsIgnoreCase(VideothequeActions.LIST_ALL_MOVIES.getValue())) {
            listOfMovie();
        }

        if (answer.equalsIgnoreCase(VideothequeActions.ADD_FILM.getValue())) {
            addNewMovie();
        }

        if (answer.equalsIgnoreCase(VideothequeActions.DELETE_FILM.getValue())) {
            deleteMovie();
        }

        if (answer.equalsIgnoreCase(VideothequeActions.SEE_FILM_TRUE.getValue())) {
            seenMovie();
        }

        if (answer.equalsIgnoreCase(VideothequeActions.MODIFY_FILM.getValue())) {
            modifyTitleMovie();
        }
        if (answer.equalsIgnoreCase(VideothequeActions.LIST_FILM_NOT_SEE.getValue())) {
            listOfMovieSeenOrNot(false);
        }
        if (answer.equalsIgnoreCase(VideothequeActions.LIST_FILM_SEE.getValue())) {
            listOfMovieSeenOrNot(true);
        }
        if (answer.equalsIgnoreCase(VideothequeActions.SORT_TITLE.getValue())) {
            movieTitleComparator();
        }
    }

    /**
     * Méthode pour récupérer tous les films dans la liste movieList et les affichent
     */
    private void listOfMovie(){
        int count = 1;
        for(Movie movie : movieList){
            ConsoleManager.getInstance().printToConsole(count + " - " + movie.toString(), true);
            count++;
        }
    }

    /**
     * Méthode pour l'ajout d'un nouveau film dans la videotheque
     */
    private void addNewMovie(){
        boolean again = false;
        do {
            try {
                ConsoleManager.getInstance().printToConsole("Vous souhaitez ajouter un nouveau film à la videotheque: ", true);
                ConsoleManager.getInstance().printToConsole("Titre : ", true);
                String title = ConsoleManager.getInstance().readUserInput();
                ConsoleManager.getInstance().printToConsole("Année de sortie : ", true);
                String releaseYear = ConsoleManager.getInstance().readUserInput();
                ConsoleManager.getInstance().printToConsole("Mois de sortie : ", true);
                String releaseMonth = ConsoleManager.getInstance().readUserInput();
                ConsoleManager.getInstance().printToConsole("Jour de sortie : ", true);
                String releaseDay = ConsoleManager.getInstance().readUserInput();
                ConsoleManager.getInstance().printToConsole("Nom du réalisateur : ", true);
                String lastname = ConsoleManager.getInstance().readUserInput();
                ConsoleManager.getInstance().printToConsole("Prénom du réalisateur : ", true);
                String firstname = ConsoleManager.getInstance().readUserInput();
                ConsoleManager.getInstance().printToConsole("Année de naissance : ", true);
                String birthYear = ConsoleManager.getInstance().readUserInput();
                ConsoleManager.getInstance().printToConsole("Mois de de naissance : ", true);
                String birthMonth = ConsoleManager.getInstance().readUserInput();
                ConsoleManager.getInstance().printToConsole("Jour de naissance : ", true);
                String birthDay = ConsoleManager.getInstance().readUserInput();
                movieList.add(new Movie(firstUpper(title), LocalDate.of(Integer.parseInt(releaseYear), Integer.parseInt(releaseMonth), Integer.parseInt(releaseDay)), new Director(firstUpper(lastname), firstUpper(firstname), LocalDate.of(Integer.parseInt(birthYear), Integer.parseInt(birthMonth), Integer.parseInt(birthDay))), false));
            } catch (Exception e){
                ConsoleManager.getInstance().printToConsole("Désolé mais le formulaire n'est pas complet", true);
            }
            ConsoleManager.getInstance().printToConsole("Vous voulez ajouter un autre titre? Oui/Non ", true);
            String choice = ConsoleManager.getInstance().readUserInput();
            again = choice.equalsIgnoreCase("oui");
        }while(again);
    }

    /**
     * Méthode pour modifier le titre d'un film de la videotheque
     */
    private void modifyTitleMovie(){
        boolean again = false;
        do {
            try {
                ConsoleManager.getInstance().printToConsole("Vous souhaitez modifier le titre d'un film: ", true);
                ConsoleManager.getInstance().printToConsole("Titre du film à modifier: ", true);
                String oldTitle = ConsoleManager.getInstance().readUserInput();
                ConsoleManager.getInstance().printToConsole("Nouveau titre: ", true);
                String modifyTitle = ConsoleManager.getInstance().readUserInput();
                for (Movie movie : movieList) {
                    if (movie.getTitle().equals(firstUpper(oldTitle))) {
                        movie.setTitle(firstUpper(modifyTitle));
                        ConsoleManager.getInstance().printToConsole("L'ancien titre " + oldTitle + " a été modifier par " + modifyTitle, true);
                    }
                }
            } catch (Exception e){
                ConsoleManager.getInstance().printToConsole("Désolé mais une erreur est survenue", true);
            }
            ConsoleManager.getInstance().printToConsole("Vous voulez modifier un autre titre? Oui/Non ", true);
            String choice = ConsoleManager.getInstance().readUserInput();
            again = choice.equalsIgnoreCase("oui");
        }while(again);
    }

    /**
     * Méthode pour supprimer un film de la videotheque
     */
    private void deleteMovie(){
        boolean again = false;
        do {
            try {
                ConsoleManager.getInstance().printToConsole("Vous souhaitez supprimer un film de la videotheque: ", true);
                ConsoleManager.getInstance().printToConsole("Titre : ", true);
                String deleteTitle = ConsoleManager.getInstance().readUserInput();
                movieList.removeIf(movie -> movie.getTitle().equals(firstUpper(deleteTitle)));
            } catch (Exception e){
                ConsoleManager.getInstance().printToConsole("Film introuvable", true);
            }
        ConsoleManager.getInstance().printToConsole("Vous voulez supprimer un autre titre? Oui/Non ", true);
        String choice = ConsoleManager.getInstance().readUserInput();
        again = choice.equalsIgnoreCase("oui");
        }while(again);
    }

    /**
     * Méthode pour changer le false en true afin d'afficher le film comme déà vu
     */
    private void seenMovie(){
        ConsoleManager.getInstance().printToConsole("Vous voulu marquer un film comme vu: ", true);
        ConsoleManager.getInstance().printToConsole("Titre : ", true);
        String seenTitle = ConsoleManager.getInstance().readUserInput();
        for(Movie movie : movieList){
            if(movie.getTitle().equals(firstUpper(seenTitle))){
                movie.setViewed(true);
                ConsoleManager.getInstance().printToConsole("Le film " + movie.getTitle() + " a été enregistré dans les vus", true);
            }
        }
    }

    /**
     * Méthode pour afficher la liste des films vu ou non suivant le paramétre ajouté (true pour les films vus OU false pour les films non vus)
     * @param viewed
     */
    private void listOfMovieSeenOrNot(boolean viewed){
        for(Movie movie : movieList){
            if(movie.getViewed() == viewed){
                ConsoleManager.getInstance().printToConsole(movie.toString(), true);
            }
        }
    }

    /**
     * Méthode pour trier les titres par ordre alphabétique
     */
    private void movieTitleComparator(){
        movieList.sort(Comparator.comparing(Movie::getTitle));
        for(Movie movie : movieList){
            ConsoleManager.getInstance().printToConsole(movie.toString(), true);
        }
    }

    /**
     * Méthode qui récupère un string en paramètre et ressort le même string avec la première lettre en majuscule
     * @param name
     * @return
     */
    private String firstUpper(String name){
        String firsLetterUpper = name.substring(0, 1).toUpperCase();
        String rest = name.substring(1, name.length()).toLowerCase();
        String all = firsLetterUpper + rest;
        return all;
    }
}
