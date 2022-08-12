package commands.editting;

import client.Client;
import commands.Command;
import commands.CommandFactory;
import server.Role;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Represents the Attach-Commands Command.
 */
public class CmdAttachCommands extends Command implements Serializable {

    /**
     * Creates new CmdAttachCommands.
     *
     * @param accessRole the role of the user
     */
    public CmdAttachCommands(Role accessRole) {
        this.accessRole = accessRole;
    }

    /**
     * Executes the command.
     */
    @Override
    public void execute() {
        System.out.println("ADDING NEW COMMANDS\n");

        System.out.println("AVAILABLE COMMANDS:");

        Map<String, Command> commands = CommandFactory.getCommands();
        List<Command> cmdList = new ArrayList<>();

        int commandNumber = 1;
        for (var command : commands.entrySet()) {
            cmdList.add(command.getValue());

            System.out.println((commandNumber++) + ". " + command.getValue().getDescription());
        }

        System.out.print("Print using space as a delimiter indexes of commands to add: ");
        Scanner scanner = new Scanner(System.in);

        String[] userInput = scanner.nextLine().split(" ");
        int[] indexes = new int[userInput.length];

        for (int i = 0; i < userInput.length; i++) {
            indexes[i] = Integer.parseInt(userInput[i].trim());

            if (indexes[i] < 1 || indexes[i] > cmdList.size()) {
                System.out.println("Incorrect index on position " + (i+1));
                return;
            }
        }

        for (int index : indexes) {
            CommandFactory.client.getCurrentPage().insertNewCommand(cmdList.get(index - 1));
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
        return "Attach command to current page";
    }
}
