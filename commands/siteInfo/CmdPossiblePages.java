package commands.siteInfo;

import commands.Command;
import pages.Page;
import pages.PageFactory;
import server.Role;

import java.io.Serializable;
import java.util.List;

/**
 * Represents the Possible-Pages Command.
 */
public class CmdPossiblePages extends Command implements Serializable {

    /**
     * Creates new CmdPossiblePages.
     *
     * @param accessRole the role of the user
     */
    public CmdPossiblePages(Role accessRole) {
        this.accessRole = accessRole;
    }

    /**
     * Executes the command.
     */
    @Override
    public void execute() {
        System.out.println("AVAILABLE PAGES:");

        List<Page> pages = PageFactory.getPages();

        int pageNumber = 1;
        for (Page page : pages)
            System.out.println((pageNumber++) + ". " + page.name);

        System.out.println();
    }

    /**
     * Returns the description of the command.
     *
     * @return the description of the command
     */
    @Override
    public String getDescription() {
        return "Print all pages that can be used in site";
    }
}
