package pages;

import server.DataBase;
import server.OrderInformation;
import server.Role;

/**
 * Represents the Orders Information Page.
 */
public class PageOrdersInformation extends Page {
    private static PageOrdersInformation orders;

    /**
     * Creates new PageOrdersInformation.
     */
    PageOrdersInformation() {
        super("Order information", Role.ADMIN);
    }

    /**
     * Returns the instance of PageOrdersInformation.
     * @return the instance of PageOrdersInformation
     */
    public static Page getPageOrderInformation() {
        if (orders == null)
            orders = new PageOrdersInformation();

        return orders;
    }

    /**
     * Returns the content of the instance of PageOrdersInformation.
     * @return the content of the instance of PageOrdersInformation
     */
    @Override
    public String getContent() {
        content = "CLOSED ORDERS\n\n";

        for (OrderInformation order : DataBase.dataBase.orders) {
            content += "order number: " + order.orderNo + " user: " + order.userName + "\n";
        }

        return content;
    }
}
