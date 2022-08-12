package commands.editting;

import client.Client;
import commands.Command;
import commands.CommandFactory;
import server.Role;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Represents the Remove Command.
 */
public class CmdRemoveCommand extends Command implements Serializable {

    /**
     * Creates new CmdRemoveCommand.
     *
     * @param accessRole the role of the user
     */
    public CmdRemoveCommand(Role accessRole) {
        this.accessRole = accessRole;
    }

    /**
     * Executes the command.
     */
    @Override
    public void execute() {
        System.out.println("REMOVING LINKS:\n");

        System.out.println("ATTACHED COMMANDS:");

        int commandNumber = 1;
        for (Command command : CommandFactory.client.getCurrentPage().attachedCommands)
            System.out.println((commandNumber++) + ". " + command.getDescription());

        System.out.print("\nEnter index of command to delete: ");

        Scanner scanner = new Scanner(System.in);

        try {
            int index = scanner.nextInt();
            CommandFactory.client.getCurrentPage().attachedCommands.remove(index - 1);
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
        return "Remove command from current page";
    }
}
