package commands.siteInfo;

import client.Client;
import commands.Command;
import commands.CommandFactory;
import server.Role;

import java.io.Serializable;

/**
 * Represents the Page-Info Command.
 */
public class CmdPageInfo extends Command implements Serializable {

    /**
     * Creates new CmdPageInfo.
     *
     * @param accessRole the role of the user
     */
    public CmdPageInfo(Role accessRole) {
        this.accessRole = accessRole;
    }

    /**
     * Executes the command.
     */
    @Override
    public void execute() {
        System.out.println("PAGE INFO: ");

        System.out.println("Current page: " + CommandFactory.client.getCurrentPage().name);

        System.out.println();

        CommandFactory.getCommandByStr("print_attached_links").execute();

        System.out.println();
    }

    /**
     * Returns the description of the command.
     *
     * @return the description of the command
     */
    @Override
    public String getDescription() {
        return "Print information about current page";
    }
}
