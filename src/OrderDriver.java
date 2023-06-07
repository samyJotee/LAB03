public class OrderDriver {
    public static void main(String[] args) {

        Order order = new Order(1);

        order.attach((OrderObserver) new PriceObserver());
        order.attach(new QuantityObserver());

        order.addItem(new Item(1, "AirPods 3", 199, 1));
        order.addItem(new Item(2, "iPhone 11 Pro", 859, 1));
        order.addItem(new Item(3, "MacBook Pro 14' M1 Pro", 2200, 1));
        order.addItem(new Item(4, "HomePod Mini", 359, 1));
        //Please remove the following comment if you want to verify that when there is a quantity of 5 items or more, the shipping costs are free :
        //order.addItem(new Item(4, "AirPods Pro Max", 689, 1));

        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Items:");
        for (Item item : order.getItems()) {
            System.out.println("" + item.getItemName() + " - Price: $" + item.getItemPrice() + ", Quantity: " + item.getQuantity());
        }
        System.out.println("Total Cost: $" + order.getTotalCost());
        System.out.println("Shipping Cost: $" + order.getShippingCost());
    }
}