package commands.actions;

import client.Client;
import commands.Command;
import commands.CommandFactory;
import pages.PageProduct;
import server.Role;

/**
 * Represents the Put-In-Shopping-Card Command.
 */
public class CmdPutInShoppingCard extends Command {

    /**
     * Creates new CmdPutInShoppingCard.
     *
     * @param accessRole the role of the user
     */
    public CmdPutInShoppingCard(Role accessRole) {
        this.accessRole = accessRole;
    }

    /**
     * Executes the command.
     */
    @Override
    public void execute() {
        CommandFactory.client.getCurrentUser().shoppingCard.add(((PageProduct)CommandFactory.client.getCurrentPage()).specifications);

        System.out.println("##################\n"+
                           "###### DONE ######\n"+
                           "##################");
    }

    /**
     * Returns the description of the command.
     *
     * @return the description of the command
     */
    @Override
    public String getDescription() {
        return "Add item to card";
    }
}
