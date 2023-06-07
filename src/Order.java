import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private List<Item> items;
    private double totalCost;
    private double shippingCost;
    private List<OrderObserver> observers;
    public Order(int orderId) {
        this.orderId = orderId;
        this.items = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.totalCost = 0.0;
        this.shippingCost = 0.0;
    }

    public void addItem(Item item) {
        items.add(item);
        totalCost = calculateTotalCost();
        updateOrder();
    }
    private double calculateTotalCost() {
        double totalCost = 0.0;
        for (Item item : items) {
            totalCost = totalCost + item.getItemPrice() * item.getQuantity();
        }
        return totalCost;
    }
    public void updateOrder() {
        notifyObservers();
    }
    public void attach(OrderObserver observer) {
        observers.add(observer);
    }
    public void detach(OrderObserver observer) {
        observers.remove(observer);
    }
    public void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }
    public int getOrderId() {
        return orderId;
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }
}