package sdps.Quiz3;

import java.util.List;

// OrderProcessor class
class OrderProcessor {
    private OrderStrategy orderStrategy;

    public OrderProcessor(OrderStrategy orderStrategy) {
        this.orderStrategy = orderStrategy;
    }

    public OrderResult processOrder(String medicineName, List<String> availableSalts) {
        return orderStrategy.processOrder(medicineName, availableSalts);
    }

    public void setOrderStrategy(OrderStrategy orderStrategy) {
        this.orderStrategy = orderStrategy;
    }
}

