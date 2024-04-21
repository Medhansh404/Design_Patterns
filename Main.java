package sdps.Quiz3;

public class Main {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();

        // Add some medicines and salts to the inventory
        inventoryManager.addMedicine("Paracetamol", 100, 10.0);
        inventoryManager.addMedicine("Ibuprofen", 50, 15.0);
        inventoryManager.addSalt("Acetaminophen", 200, 5.0);
        inventoryManager.addSalt("Ibuprofen Sodium", 150, 8.0);
        inventoryManager.addSalt("Caffeine", 75, 3.0);

        OrderingPlatform orderingPlatform = new OrderingPlatform();

        // Test direct order
        OrderResult directOrder = orderingPlatform.orderMedicine("Paracetamol", inventoryManager);
        System.out.println("Direct Order: " + directOrder.getMessage() + " Price: " + directOrder.getPrice());

        // Test compound order
        OrderResult compoundOrder = orderingPlatform.orderMedicine("CompoundMedicine", inventoryManager);
        System.out.println("Compound Order: " + compoundOrder.getMessage() + " Price: " + compoundOrder.getPrice());

        // Test unavailable order
        OrderResult unavailableOrder = orderingPlatform.orderMedicine("UnavailableMedicine", inventoryManager);
        System.out.println("Unavailable Order: " + unavailableOrder.getMessage());
    }
}