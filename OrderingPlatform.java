package sdps.Quiz3;


import java.util.List;

class OrderingPlatform {
private InventoryManager inventoryManager;
private OrderProcessor orderProcessor;

public OrderingPlatform() {
        inventoryManager = new InventoryManager();
        orderProcessor = new OrderProcessor(new DirectOrderStrategy());
        }

public OrderResult orderMedicine(String medicineName, InventoryManager inventoryManager) {
        System.out.println(inventoryManager.getAvailableSalts(medicineName));
        List<String> availableSalts = inventoryManager.getAvailableSalts(medicineName);
        System.out.println(availableSalts);
        OrderResult orderResult = orderProcessor.processOrder(medicineName, availableSalts);
        if (orderResult.isSuccessful()) {
        return orderResult;
        } else {
        orderProcessor.setOrderStrategy(new CompoundOrderStrategy());
        orderResult = orderProcessor.processOrder(medicineName, availableSalts);
        if (orderResult.isSuccessful()) {
        return orderResult;
        } else {
        return orderResult;
        }
        }
        }

public void registerObserver(StockObserver observer) {
        inventoryManager.attach(observer);
        }

public void unregisterObserver(StockObserver observer) {
        inventoryManager.detach(observer);
        }
        }