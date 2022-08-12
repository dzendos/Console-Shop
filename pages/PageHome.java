package pages;

import server.Role;

import java.io.Serializable;

/**
 * Represents the home page.
 */
public class PageHome extends Page implements Serializable {
    private static PageHome home;

    /**
     * Creates new home page.
     */
    private PageHome() {
        super("Home", Role.GUEST);

        content = "Welcome to GoGreen!\n" +
                  "Dozens of plants you dreamed about!\n";
    }

    /**
     * Returns the home page.
     * @return the home page
     */
    public static Page getHomePage() {
        if (home == null)
            home = new PageHome();

        return home;
    }
}
