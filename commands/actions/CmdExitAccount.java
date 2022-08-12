package commands.actions;

import client.Client;
import commands.Command;
import commands.CommandFactory;
import server.Role;
import server.User;

import java.io.Serializable;

/**
 * Represents the Exit Account Command.
 */
public class CmdExitAccount extends Command implements Serializable {

    /**
     * Creates new CmdExitAccount.
     *
     * @param accessRole the role of the user
     */
    public CmdExitAccount(Role accessRole) {
        this.accessRole = accessRole;
    }

    /**
     * Executes the command.
     */
    @Override
    public void execute() {
        CommandFactory.client.setCurrentUser(User.getGuest());
    }

    /**
     * Returns the description of the command.
     *
     * @return the description of the command
     */
    @Override
    public String getDescription() {
        return "Exit from account in the current client";
    }
}
