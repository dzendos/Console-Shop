package commands.siteInfo;

import client.Client;
import commands.Command;
import commands.CommandFactory;
import server.Role;
import server.product.ProductSpecificationFactory;

/**
 * Represents the Show-Shopping-Card Command.
 */
public class CmdShowShoppingCard extends Command {

    /**
     * Creates new CmdShowShoppingCard.
     *
     * @param accessRole the role of the user
     */
    public CmdShowShoppingCard(Role accessRole) {
        this.accessRole = accessRole;
    }

    /**
     * Executes the command.
     */
    @Override
    public void execute() {
        System.out.println("SHOPPING LIST:\n");

        int totalPrice = 0;

        for (ProductSpecificationFactory product : CommandFactory.client.getCurrentUser().shoppingCard) {
            System.out.println(product.parameters.get(0).description + " " + product.price + "$");
            totalPrice += product.price;
        }

        System.out.println();

        System.out.println("Total price: " + totalPrice + "$");
    }

    /**
     * Returns the description of the command.
     *
     * @return the description of the command
     */
    @Override
    public String getDescription() {
        return "Print my shopping list";
    }
}
