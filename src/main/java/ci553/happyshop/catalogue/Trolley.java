package ci553.happyshop.catalogue;

import java.util.ArrayList;

public class Trolley {
    public ArrayList<Product> products = new ArrayList<>();

    /**
     * Adds a product to the trolley.
     * Currently the product is simply appended to the end of the list.
     * <p>
     * TODO — Improve trolley organisation:
     * 1. Merge products with the same product ID (combine quantities).
     * 2. Sorts the products in the trolley by product ID.
     * <p>
     * Possible approaches:
     * <p>
     * Approach 1 (simplest):
     * Modify addProduct() to handle merging and sorting directly.
     * <p>
     * Approach 2:
     * Create a new method (e.g. addProductOrganised()) that performs the
     * merging and sorting logic.
     * Then call this method instead of addProduct() from addToTrolley() in CustomerModel.
     * <p>
     * Approach 3 (more advanced):
     * Create a subclass such as OrganizedTrolley that overrides addProduct().
     * Then in CustomerModel:
     * private Trolley trolley = new OrganizedTrolley();
     * This allows the trolley behaviour to be changed without modifying
     * the existing Trolley class.
     * <p>
     * Approach 4 (advanced design using a design pattern – Factory Pattern)
     * (covered later in the "Design Patterns" topic).
     * <p>
     * Instead of directly creating the trolley in CustomerModel:
     * private Trolley trolley = new Trolley();
     * create a method such as:
     * Trolley createTrolley(), which returns a Trolley.
     * Then create a subclass such as OrganizedCustomerModel that overrides
     * createTrolley() to return an OrganizedTrolley.
     * <p>
     * The system can decide which model to use (CustomerModel or OrganizedCustomerModel)
     * in CustomerClient, Main, or other appropriate places in the application.
     * Either model can be used independently, or both can coexist,
     * allowing different trolley behaviours at the same time.
     * <p>
     * code examples:
     * public CustomerModel(...) { trolley = createTrolley(); ...}
     * <p>
     * protected Trolley createTrolley() { return new Trolley(); }
     * <p>
     * class OrganizedCustomerModel extends CustomerModel {
     *
     * @Override protected Trolley createTrolley() {
     * return new OrganizedTrolley();
     * }
     * }
     **/

    public void addProduct(Product nextProd) {
        String nextProdId = nextProd.getProductId(); // gets the next products id to compare
        for (int i = 0; i < products.size(); i++){
            Product prevProd = products.get(i); // gets the previous product added to products
            String prevProdId = prevProd.getProductId();

            if(nextProdId.equals(prevProdId)){
               int totalQuant = prevProd.getOrderedQuantity() + 1;
               prevProd.setOrderedQuantity(totalQuant);
               return;
            }
        }
        products.add(nextProd);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void clear() {
        products.clear();
    }
}

