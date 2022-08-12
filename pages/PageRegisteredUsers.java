package pages;

import server.DataBase;
import server.Role;
import server.User;

import java.io.Serializable;

/**
 * Represents the Page of Registered Users.
 */
public class PageRegisteredUsers extends Page implements Serializable {

    private static PageRegisteredUsers registeredUsers;

    /**
     * Creates new PageRegisteredUsers.
     */
    PageRegisteredUsers() {
        super("Registered users", Role.ADMIN);
    }

    /**
     * Returns the instance of getRegisteredUsersPage.
     * @return the instance of getRegisteredUsersPage
     */
    public static Page getRegisteredUsersPage() {
        if (registeredUsers == null)
            registeredUsers = new PageRegisteredUsers();

        return registeredUsers;
    }

    /**
     * Returns the content of the instance of getRegisteredUsersPage.
     * @return the content of the instance of getRegisteredUsersPage
     */
    @Override
    public String getContent() {
        content = "REGISTERED IN SYSTEM USERS:\n\n";

        int userNumber = 1;
        for (User user : DataBase.getUsers()) {
            content += (userNumber++) + ". name: " + user.name + " login: " + user.login
                    + " role: " + user.role + " password: " + user.password;
        }

        return content;
    }
}
