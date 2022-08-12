package server;

import client.Client;
import commands.actions.CmdChangePage;
import commands.Command;
import commands.CommandFactory;
import pages.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the server.
 */
public class Server {

    /**
     * Loads the page.
     *
     * @param client the client in which we are load the page.
     * @return the list of available commands.
     */
    public static List<Command> loadPage(Client client) {

        System.out.println(client.getCurrentPage().getContent());

        System.out.println();

        System.out.println("AVAILABLE ACTIONS:");

        List<Command> actions = new ArrayList<>();

        int actionIndex = 1;

        if (client.getCurrentPage().nextPages.size() != 0)
            System.out.println("------------ NEXT PAGES --------------");

        for (Page page : client.getCurrentPage().nextPages) {
            if (client.getCurrentUser().role.ordinal() <= page.accessRole.ordinal()) {
                System.out.println((actionIndex++) + ". go to " + page.name + " page");
                actions.add(new CmdChangePage(page, client));
            }
        }

        if (client.getCurrentPage().attachedCommands.size() != 0)
            System.out.println("-------- AVAILABLE COMMANDS ----------");

        for (Command cmd : client.getCurrentPage().attachedCommands) {
            if (client.getCurrentUser().role.ordinal() <= cmd.accessRole.ordinal()) {
                System.out.println((actionIndex++) + ". " + cmd.getDescription());
                actions.add(cmd);
            }
        }

        if (CommandFactory.interfaceCommands.size() != 0)
            System.out.println("--------------------------------------");

        for (Command cmd : CommandFactory.interfaceCommands) {
            if (client.getCurrentUser().role.ordinal() <= cmd.accessRole.ordinal()) {
                System.out.println((actionIndex++) + ". " + cmd.getDescription());
                actions.add(cmd);
            }
        }

        return actions;
    }
}
