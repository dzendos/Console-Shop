package server;

import server.product.ProductSpecificationFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the user.
 */
public class User implements Serializable {
    private static final User guest = new User("", "", "", Role.GUEST);

    public List<ProductSpecificationFactory> shoppingCard = new ArrayList<>();

    public String name;
    public String login;
    public String password;

    public Role   role;

    /**
     * Creates the new user without any parameters.
     */
    public User() {
    }

    /**
     * Creates the new user with given parameters.
     *
     * @param name the name of the user
     * @param login the login of the user
     * @param password the password of the user
     * @param role the role of the user
     */
    public User(String name, String login, String password, Role role) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    /**
     * Returns the Guest value.
     * @return the Guest value
     */
    public static User getGuest() {
        return guest;
    }
}
