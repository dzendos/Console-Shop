package commands.actions;

import client.Client;
import commands.Command;
import commands.CommandFactory;
import pages.Page;
import server.Role;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

/**
 * Represents the Go-To-Page Command.
 */
public class CmdGoToPage extends Command implements Serializable {

    /**
     * Creates new CmdGoToPage.
     *
     * @param accessRole the role of the user
     */
    public CmdGoToPage(Role accessRole) {
        this.accessRole = accessRole;
    }

    /**
     * Executes the command.
     */
    @Override
    public void execute() {
        if (CommandFactory.client.getCurrentPage().nextPages.size() == 0) {
            System.out.println("Nothing to go\n");
            return;
        }

        CommandFactory.getCommandByStr("print_attached_links").execute();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter index of page to go: ");

        int index = scanner.nextInt();

        List<Page> pages = CommandFactory.client.getCurrentPage().nextPages;

        if (index < 1 || index > pages.size()) {
            System.out.println("Incorrect index\n");
            return;
        }

        CommandFactory.client.setCurrentPage(pages.get(index - 1));

        System.out.println();
    }

    /**
     * Returns the description of the command.
     *
     * @return the description of the command
     */
    @Override
    public String getDescription() {
        return "Move client to another page";
    }
}
