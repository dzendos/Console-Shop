package pages;

import server.Role;

import java.io.Serializable;

/**
 * Represents the Products Page.
 */
public class PageProducts extends Page implements Serializable {

    private static PageProducts products = null;

    /**
     * Creates new PageProducts.
     */
    PageProducts() {
        super("Products", Role.GUEST);

        content = "Our store has a wide range of products. Hope, you can find everything you want!";
    }

    /**
     * Returns the instance of the PageProducts.
     * @return the instance of the PageProducts
     */
    public static Page getPageProducts() {
        if (products == null)
            products = new PageProducts();

        return products;
    }
}
