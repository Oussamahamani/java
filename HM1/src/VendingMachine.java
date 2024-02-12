import java.util.HashMap;
import java.util.Stack;

public class VendingMachine {

    double sales = 0;

    HashMap<String, ProductList> catalog = new HashMap<>();

    /**
     * stock item in the machine.
     */
    public void stockItems(String location, Stack<Product> itemList, double unitPrice){

        catalog.put(location,new ProductList(itemList,unitPrice));
    }

    /**
     * Print all inventory.
     */
    public void printInventory(){
        for(String key :this.catalog.keySet()){
            System.out.println( key );
            for(Product element:this.catalog.get(key).list){
                System.out.println(" - "+element.productName);
            }
        }
    }

    /**
     * Get all sales.
     */
    public double getTotalSales(){
    return this.sales;
    }

    /**
     * purchase a product and return the product
     */
    public VendingMachineOutput purchase(String location,double amount){
        ProductList item = this.catalog.get(location);
        if(item == null){
            throw new IllegalArgumentException("slot does not exist");
        }
        Stack itemList=   item.list;
        if(itemList.empty()){
            throw new IllegalArgumentException("there is no more products");
        }
        double cost = item.price;
        double change = amount -cost;
        if(cost>amount){
            throw new IllegalArgumentException("amount of money is not enough to buy the product");
        }
        this.sales+=cost;
        itemList.pop();
       return new VendingMachineOutput(change, (Product) itemList.getFirst());


    }
}
