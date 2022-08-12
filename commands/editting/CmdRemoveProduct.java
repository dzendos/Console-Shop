package commands.editting;

import commands.Command;
import pages.Page;
import pages.PageFactory;
import server.Role;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Represents the Remove-Product Command.
 */
public class CmdRemoveProduct extends Command implements Serializable {

    /**
     * Creates new CmdRemoveProduct.
     *
     * @param accessRole the role of the user
     */
    public CmdRemoveProduct(Role accessRole) {
        this.accessRole = accessRole;
    }

    /**
     * Executes the command.
     */
    @Override
    public void execute() {
        System.out.println("REMOVING PAGE");

        int pageNumber = 1;
        for (Page page : PageFactory.getPages()) {
            System.out.println((pageNumber++) + ". " + page.name);
        }

        System.out.print("Enter index of page ro delete: ");
        Scanner scanner = new Scanner(System.in);

        try {
            int index = scanner.nextInt();
            PageFactory.getPages().remove(index - 1);
        } catch (Exception ex) {
            System.out.println("Invalid index");
        }
    }

    /**
     * Returns the description of the command.
     *
     * @return the description of the command
     */
    @Override
    public String getDescription() {
        return "Remove page";
    }
}
