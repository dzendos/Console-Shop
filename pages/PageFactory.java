package pages;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the Page Factory.
 */
public class PageFactory implements Serializable {
    public List<Page> pages = new ArrayList<>();

    private static PageFactory factory = null;

    /**
     * Creates new Page Factory.
     */
    private PageFactory() {
        pages.add(PageHome.getHomePage());
        pages.add(PageStatistics.getStatisticsPage());
        pages.add(PageRegisteredUsers.getRegisteredUsersPage());
        pages.add(PageProducts.getPageProducts());
        pages.add(PageOrdersInformation.getPageOrderInformation());
    }

    /**
     * Initializes the Page Factory.
     */
    public static void initialize() {
        if (factory == null)
            factory = new PageFactory();
    }

    /**
     * Returns the list of possible pages.
     *
     * @return the list of possible pages
     */
    public static List<Page> getPages() {
        return factory.pages;
    }

    /**
     * Returns the factory.
     * @return the factory
     */
    public static PageFactory getFactory() {
        return factory;
    }

    /**
     * Sets the factory.
     *
     * @param newFactory the factory to be set
     */
    public static void setFactory(PageFactory newFactory) {
        factory = newFactory;
    }

    /**
     * Gets the page by its name.
     *
     * @param name the name to be searched
     * @return the page found
     */
    public static Page getPageByName(String name) {
        for (Page page : factory.pages) {
            if (page.name.equals(name))
                return page;
        }

        return null;
    }
}
