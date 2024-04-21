// SaltComposer class
package sdps.Quiz3;

import java.util.List;

class SaltComposer {
    public OrderResult composeOrder(String medicineName, List<String> availableSalts) {
        InventoryManager inventoryManager = new InventoryManager();
        if (availableSalts.size() == 1 && inventoryManager.isSaltAvailable(availableSalts.get(0))) {
            double price = inventoryManager.getSaltPrice(availableSalts.get(0));
            return OrderResult.successful(price);
        } else if (availableSalts.size() > 1) {
            double totalPrice = 0.0;
            for (String salt : availableSalts) {
                if (inventoryManager.isSaltAvailable(salt)) {
                    totalPrice += inventoryManager.getSaltPrice(salt);
                } else {
                    return OrderResult.unavailable();
                }
            }
            return OrderResult.successful(totalPrice);
        } else {
            return OrderResult.unavailable();
        }
    }
}