package videoLibrary.service;

import videoLibrary.utils.ConsoleManager;

public abstract class RunnableServiceAbstractImpl implements RunnableService {

    protected void printTitle(String title) {
        ConsoleManager.getInstance().consoleLineBreak();
        ConsoleManager.getInstance().printLine();
        ConsoleManager.getInstance().printToConsole(title, true);
        ConsoleManager.getInstance().printLine();
        ConsoleManager.getInstance().consoleLineBreak();
    }

    protected String printMenu(videoLibrary.service.action.VideothequeActions[] actions) {
        boolean rightAnswer = false;
        String answer = "";

        do {
            // print the option menu
            ConsoleManager.getInstance().printLine();
            ConsoleManager.getInstance().consoleLineBreak();

            for (videoLibrary.service.action.VideothequeActions action : actions) {
                ConsoleManager.getInstance().printToConsole(action.toString(), true);
            }

            ConsoleManager.getInstance().printToConsole("Que voulez-vous faire : ", false);

            // ask user answer
            answer = ConsoleManager.getInstance().readUserInput();

            if (videoLibrary.service.action.VideothequeActions.containsAction(answer)) {
                rightAnswer = true;
            }
        } while (!rightAnswer);

        return answer;
    }

}

