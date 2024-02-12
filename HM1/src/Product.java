public abstract  class Product {

    public Product(String productName) {
        this.productName = productName;
    }

    public String productName;

    abstract public void consume();
}
