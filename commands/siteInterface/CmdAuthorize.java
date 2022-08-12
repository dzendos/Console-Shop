package commands.siteInterface;

import client.Client;
import commands.Command;
import commands.CommandFactory;
import server.DataBase;
import server.Role;
import server.User;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Represents the Authorize Command.
 */
public class CmdAuthorize extends Command implements Serializable {

    /**
     * Creates new CmdAuthorize.
     *
     * @param accessRole the role of the user
     */
    public CmdAuthorize(Role accessRole) {
        this.accessRole = accessRole;
    }

    /**
     * Executes the command.
     */
    @Override
    public void execute() {
        System.out.println("AUTHORIZATION:");

        Scanner scanner = new Scanner(System.in);

        String login;
        String password;

        System.out.print("Enter your login: ");
        login = scanner.next();

        System.out.print("Enter your password: ");
        password = scanner.next();

        User user;

        if ((user = DataBase.getUserByData(login, password)) == null)
            System.out.println("Server.User with such data was not found");
        else {
            System.out.println("Welcome back, " + user.name + "!");
            CommandFactory.client.setCurrentUser(user);
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
        return "Authorize the user";
    }
}
