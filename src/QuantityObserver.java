public class QuantityObserver implements OrderObserver {
    private static final double DEFAULT_SHIPPING_COST = 10;
    private static final double ZERO_SHIPPING_COST = 0;

    @Override
    public void update(Order order) {
        if (order.getItems().size() >= 5) {
            order.setShippingCost(ZERO_SHIPPING_COST);
        } else {
            order.setShippingCost(DEFAULT_SHIPPING_COST);
        }
    }
}