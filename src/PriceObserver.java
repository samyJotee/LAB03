public class PriceObserver implements OrderObserver {
    private static final double DISCOUNT_AMOUNT = 20;
    @Override
    public void update(Order order) {
        if (order.getTotalCost() > 200) {
            order.setTotalCost(order.getTotalCost() - DISCOUNT_AMOUNT);
        }
    }
}