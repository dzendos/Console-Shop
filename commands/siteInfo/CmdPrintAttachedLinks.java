package commands.siteInfo;

import client.Client;
import commands.Command;
import commands.CommandFactory;
import pages.Page;
import server.Role;

import java.io.Serializable;
import java.util.List;

/**
 * Represents the Print-Attached-Links Command.
 */
public class CmdPrintAttachedLinks extends Command implements Serializable {

    /**
     * Creates new CmdPrintAttachedLinks.
     *
     * @param accessRole the role of the user
     */
    public CmdPrintAttachedLinks(Role accessRole) {
        this.accessRole = accessRole;
    }

    /**
     * Executes the command.
     */
    @Override
    public void execute() {
        System.out.println("ATTACHED LINKS:");

        List<Page> pages = CommandFactory.client.getCurrentPage().nextPages;

        for (int i = 0; i < pages.size(); i++) {
            System.out.println((i+1) + ". " + pages.get(i).name);
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
        return "Print all links attached to the current page";
    }
}
