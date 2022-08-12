package server;

import java.io.Serializable;

/**
 * Represents the order information.
 */
public class OrderInformation implements Serializable {
    public int orderNo;
    public String userName;

    /**
     * Creates new order.
     *
     * @param orderNo the number of the order.
     * @param userName the name of the user.
     */
    public OrderInformation(int orderNo, String userName) {
        this.orderNo = orderNo;
        this.userName = userName;
    }
}
