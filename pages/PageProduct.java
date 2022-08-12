package pages;

import server.Role;
import server.product.ProductSpecification;
import server.product.ProductSpecificationFactory;

import java.io.Serializable;

/**
 * Represents the Product Page.
 */
public class PageProduct extends Page implements Serializable {

    public ProductSpecificationFactory specifications;

    /**
     * Creates new PageProduct with the given name.
     * @param name the given name
     */
    public PageProduct(String name) {
        super(name, Role.GUEST);
        specifications = new ProductSpecificationFactory();

        content = "Beautiful plant " + name + "!";

        nextPages.add(PageFactory.getPageByName("Products"));

        PageFactory.getPageByName("Products").nextPages.add(this);
    }

    /**
     * Gets the content of the product page.
     * @return the content of the product page
     */
    @Override
    public String getContent() {
        StringBuilder result = new StringBuilder(content + "\n");

        result.append("\nPRODUCT SPECIFICATIONS:\n");

        for (ProductSpecification specification : specifications.parameters) {
            result.append(specification.specification).append(": ").append(specification.description).append("\n");
        }

        result.append("\nPrice: " + specifications.price + "$");

        return result.toString();
    }
}