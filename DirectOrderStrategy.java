package sdps.Quiz3;

import java.util.List;

// DirectOrderStrategy class
class DirectOrderStrategy implements OrderStrategy {
    @Override
    public OrderResult processOrder(String medicineName, List<String> availableSalts) {
        InventoryManager inventoryManager = new InventoryManager();
        if (inventoryManager.isMedicineAvailable(medicineName)) {
            double price = inventoryManager.getMedicinePrice(medicineName);
            return OrderResult.successful(price);
        } else {
            return OrderResult.unavailable();
        }
    }
}
