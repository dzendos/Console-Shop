package commands.actions;

import client.Client;
import commands.Command;
import pages.Page;

import java.io.Serializable;

/**
 * Represents the command of changing page.
 */
public class CmdChangePage extends Command implements Serializable {
    Page nextPage;
    Client client;

    /**
     * Creates new command of changing page.
     *
     * @param nextPage page to which we are going to change
     * @param client the client in which we are going to change
     */
    public CmdChangePage(Page nextPage, Client client) {
        this.nextPage = nextPage;
        this.client = client;
    }

    /**
     * Executes the command.
     */
    @Override
    public void execute() {
        client.setCurrentPage(nextPage);
    }

    /**
     * Returns the description of the command.
     *
     * @return the description of the command
     */
    @Override
    public String getDescription() {
        return "Move user to another page";
    }
}
