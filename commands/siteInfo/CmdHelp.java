package commands.siteInfo;

import commands.Command;
import commands.CommandFactory;
import server.Role;

import java.io.Serializable;
import java.util.Map;

/**
 * Represents the Help Command.
 */
public class CmdHelp extends Command implements Serializable {

    /**
     * Creates new CmdHelp.
     *
     * @param accessRole the role of the user
     */
    public CmdHelp(Role accessRole) {
        this.accessRole = accessRole;
    }

    /**
     * Executes the command.
     */
    @Override
    public void execute() {
        System.out.println("AVAILABLE COMMANDS:");

        Map<String, Command> commands = CommandFactory.getCommands();

        for (var command : commands.entrySet()) {
                System.out.println(command.getKey() + " - " + command.getValue().getDescription());
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
        return "Print all possible commands and their description";
    }
}
