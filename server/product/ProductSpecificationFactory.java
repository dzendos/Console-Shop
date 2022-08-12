package server.product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the Product Specification Factory.
 */
public class ProductSpecificationFactory implements Serializable {
    public List<ProductSpecification> parameters = new ArrayList<>();

    public int price;

    /**
     * Creates the new Product Specification Factory.
     */
    public ProductSpecificationFactory() {
        parameters.add(new ProductSpecification("Botanical Name", null));
        parameters.add(new ProductSpecification("Mature Height",  null));
        parameters.add(new ProductSpecification("Mature Spread",  null));
        parameters.add(new ProductSpecification("Sun Exposure",   null));
        parameters.add(new ProductSpecification("Soil",           null));
        parameters.add(new ProductSpecification("Moisture",       null));
        parameters.add(new ProductSpecification("Growth Rate",    null));
    }
}
