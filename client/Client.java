package client;

import server.DataBase;
import server.Server;
import commands.Command;
import commands.CommandFactory;
import pages.Page;
import pages.PageFactory;
import server.User;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

/**
 * Represents the client.
 */
public class Client implements Serializable {
    private Page currentPage;
    private User currentUser;

    /**
     * Initializes the client.
     */
    private void initialize() {
        CommandFactory.initialize(this);
        DataBase.initialize();

        currentUser = User.getGuest();

        try {
            currentPage = PageFactory.getPages().get(0);
        } catch(Exception ex) {
            System.out.println("No available pages");
        }
    }

    /**
     * Runs the client.
     */
    public void run() {
        initialize();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();

            System.out.println("############################################");


            List<Command> pageActions = Server.loadPage(this);
            execute(pageActions, scanner);
        }
    }

    /**
     * Reads and executes the commands.
     *
     * @param pageActions the list of available commands
     * @param scanner the scanner
     */
    private void execute(List<Command> pageActions, Scanner scanner) {
        boolean isIndexOkay = false;

        while (!isIndexOkay) {
            System.out.print("Enter index of action to execute: ");

            try {
                int index = Integer.parseInt(scanner.next());
                pageActions.get(index - 1).execute();
                isIndexOkay = true;
            } catch (Exception ex) {
                System.out.print("Invalid index. ");
            }
        }
    }

    /**
     * Returns the current page.
     *
     * @return the current page
     */
    public Page getCurrentPage() {
        return currentPage;
    }

    /**
     * Sets the current page.
     *
     * @param page the page to be set
     */
    public void setCurrentPage(Page page) {
        currentPage = page;
    }

    /**
     * Returns the current user.
     *
     * @return the current user
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * Sets the current user.
     *
     * @param currentUser the user to be set
     */
    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
