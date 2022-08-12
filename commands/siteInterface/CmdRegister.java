package commands.siteInterface;

import commands.Command;
import server.DataBase;
import server.Role;
import server.User;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Represents the Register Command.
 */
public class CmdRegister extends Command implements Serializable {

    /**
     * Creates new CmdRegister.
     *
     * @param accessRole the role of the user
     */
    public CmdRegister(Role accessRole) {
        this.accessRole = accessRole;
    }

    /**
     * Executes the command.
     */
    @Override
    public void execute() {
        System.out.println("REGISTERING NEW USER\n");

        User user = new User();

        Scanner scanner = new Scanner(System.in);

        boolean isLoginValid = false;
        while (!isLoginValid) {
            System.out.print("Enter login: ");
            user.login = scanner.next();

            if (!DataBase.containsUser(user.login))
                isLoginValid = true;
            else {
                System.out.print("Server.User with such login already exists. ");
            }
        }

        System.out.print("Enter name: ");
        user.name = scanner.next();

        System.out.print("Enter password: ");
        user.password = scanner.next();

        user.role = Role.CLIENT;

        DataBase.addUser(user);

        System.out.println();
    }

    /**
     * Returns the description of the command.
     *
     * @return the description of the command
     */
    @Override
    public String getDescription() {
        return "Register new user";
    }
}
