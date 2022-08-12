package pages;

import server.Role;
import commands.Command;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the page.
 */
public class Page implements Serializable {
    protected String content;
    public List<Page> nextPages = new ArrayList<>();

    public List<Command> attachedCommands = new ArrayList<>();

    public String name;

    public Role accessRole;

    /**
     * Creates the new page with given parameters.
     *
     * @param name the name of the page
     * @param accessRole the role of the user
     */
    Page(String name, Role accessRole) {
        this.name = name;
        this.accessRole = accessRole;
    }

    /**
     * Inserts the new page to the list of available pages.
     * @param page the page to be inserted
     */
    public void insertNewPage(Page page) {
        nextPages.add(page);
    }

    /**
     * Inserts the new command to the list of available commands.
     *
     * @param command the command to be inserted
     */
    public void insertNewCommand(Command command) {
        attachedCommands.add(command);
    }

    /**
     * Return the content of the page.
     *
     * @return the content of the page
     */
    public String getContent() {
        return content;
    }
}
