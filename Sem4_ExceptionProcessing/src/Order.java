
public class Order {
    Customer customer;
    Item item;
    int quantity;

    public Order(Customer customer, Item item, int quantity) {
        this.customer = customer;
        this.item = item;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{customer=" + customer + ", item=" + item + ", quantity=" + quantity + "}";
    }
}