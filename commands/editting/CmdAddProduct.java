package commands.editting;

import client.Client;
import commands.Command;
import commands.CommandFactory;
import pages.PageFactory;
import pages.PageProduct;
import server.Role;
import server.product.ProductSpecification;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Represents the Add-Product Command.
 */
public class CmdAddProduct extends Command implements Serializable {

    /**
     * Creates new CmdAddProduct.
     *
     * @param accessRole the role of the user
     */
    public CmdAddProduct(Role accessRole) {
        this.accessRole = accessRole;
    }

    /**
     * Executes the command.
     */
    @Override
    public void execute() {
        System.out.println("ADDING NEW PRODUCT:");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();

        PageProduct product = new PageProduct(productName);

        System.out.print("Print price: ");
        product.specifications.price = scanner.nextInt();

        product.attachedCommands.add(CommandFactory.getCommands().get("add_item_in_card"));

        for (ProductSpecification specification : product.specifications.parameters) {
            System.out.print(specification.specification + ": ");
            specification.description = scanner.next();
        }

        PageFactory.getPages().add(product);

    }

    /**
     * Returns the description of the command.
     *
     * @return the description of the command
     */
    @Override
    public String getDescription() {
        return "Add new Product";
    }
}
