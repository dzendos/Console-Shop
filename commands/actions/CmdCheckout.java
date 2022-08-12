package commands.actions;

import client.Client;
import commands.Command;
import commands.CommandFactory;
import server.DataBase;
import server.OrderInformation;
import server.Role;

/**
 * Represents the Checkout Command.
 */
public class CmdCheckout extends Command {

    /**
     * Creates new CmdCheckout.
     *
     * @param accessRole the role of the user
     */
    public CmdCheckout(Role accessRole) {
        this.accessRole = accessRole;
    }

    /**
     * Executes the command.
     */
    @Override
    public void execute() {
        System.out.println("THANK YOU FOR PURCHASE!\n");
        DataBase.dataBase.orders.add(new OrderInformation(DataBase.dataBase.orderNo++, CommandFactory.client.getCurrentUser().name));
        CommandFactory.client.getCurrentUser().shoppingCard.clear();
    }

    /**
     * Returns the description of the command.
     *
     * @return the description of the command
     */
    @Override
    public String getDescription() {
        return "Go to check out";
    }
}
