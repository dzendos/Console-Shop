package server.product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the product specification.
 */
public class ProductSpecification implements Serializable {
    public String specification;
    public String description;

    /**
     * Creates new Product Specification.
     *
     * @param specification the specification of the product
     * @param description the description of the product
     */
    public ProductSpecification(String specification, String description) {
        this.specification = specification;
        this.description = description;
    }
}
