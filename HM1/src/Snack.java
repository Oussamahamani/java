public class Snack extends Product {



    public Snack(String productName) {
        super(productName);
    }
    /**
     * Consume the Snack.
     */
    @Override
    public void consume() {
        System.out.println("Yum, you eat the "+this.productName);
    }
}
