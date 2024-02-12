public class Drink extends Product {




    public Drink(String productName) {
        super(productName);
    }

    /**
     * Consume the Drink.
     */
    @Override
    public void consume() {
        System.out.println("Yum, you drink the "+this.productName);
    }
}
