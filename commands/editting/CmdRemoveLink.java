package commands.editting;

import client.Client;
import commands.Command;
import commands.CommandFactory;
import server.Role;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Represents the Remove-Link Command.
 */
public class CmdRemoveLink extends Command implements Serializable {

    /**
     * Creates new CmdRemoveLink.
     *
     * @param accessRole the role of the user
     */
    public CmdRemoveLink(Role accessRole) {
        this.accessRole = accessRole;
    }

    /**
     * Executes the command.
     */
    @Override
    public void execute() {
        System.out.println("REMOVING LINKS:\n");

        CommandFactory.getCommandByStr("print_attached_links").execute();

        System.out.print("Enter index of link to delete: ");

        Scanner scanner = new Scanner(System.in);

        try {
            int index = scanner.nextInt();
            CommandFactory.client.getCurrentPage().nextPages.remove(index - 1);
        } catch (Exception ex) {
            System.out.println("Index is invalid");
        }

        System.out.println();
    }

    /**
     * Returns the description of the command.
     *
     * @return the description of the command
     */
    @Override
    public String getDescription() {
        return "Remove attached link from current page";
    }
}
