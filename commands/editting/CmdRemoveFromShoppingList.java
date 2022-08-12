package commands.editting;

import client.Client;
import commands.Command;
import commands.CommandFactory;
import server.Role;
import server.product.ProductSpecificationFactory;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Represents the Remove-From-Shopping-List Command.
 */
public class CmdRemoveFromShoppingList extends Command implements Serializable {
    private Client client;

    /**
     * Creates new CmdRemoveFromShoppingList.
     *
     * @param accessRole the role of the user
     */
    public CmdRemoveFromShoppingList(Role accessRole, Client client){
        this.accessRole = accessRole;
        this.client = client;
    }

    /**
     * Executes the command.
     */
    @Override
    public void execute() {
        System.out.println("REMOVING FROM SHOPPING LIST:\n");

        System.out.println("SHOPPING LIST:");

        int productNumber = 1;
        for (ProductSpecificationFactory product : client.getCurrentUser().shoppingCard)
            System.out.println((productNumber++) + ". " + product.parameters.get(0).description + " " + product.price + "$");

        System.out.print("\nEnter index of product to delete: ");

        Scanner scanner = new Scanner(System.in);

        try {
            int index = scanner.nextInt();
            CommandFactory.client.getCurrentUser().shoppingCard.remove(index - 1);
        } catch (Exception ex) {
            System.out.println("Index is invalid");
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
        return "Remove product from shopping list";
    }
}
