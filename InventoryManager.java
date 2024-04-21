package sdps.Quiz3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class InventoryManager {
    private List<StockObserver> observers = new ArrayList<>();
    private Map<String, Integer> medicineStock = new HashMap<>();
    private Map<String, Double> medicinePrices = new HashMap<>();
    private Map<String, Integer> saltStock = new HashMap<>();
    private Map<String, Double> saltPrices = new HashMap<>();

    public void attach(StockObserver observer) {
        observers.add(observer);
    }

    public void detach(StockObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String medicineName, int newStock) {
        for (StockObserver observer : observers) {
            observer.update(medicineName, newStock);
        }
    }

    public void updateStock(String medicineName, int newStock) {
        medicineStock.put(medicineName, newStock);
        notifyObservers(medicineName, newStock);
    }

    public boolean isMedicineAvailable(String medicineName) {
        return medicineStock.containsKey(medicineName) && medicineStock.get(medicineName) > 0;
    }

    public double getMedicinePrice(String medicineName) {
        return medicinePrices.get(medicineName);
    }

    public void addMedicine(String medicineName, int stock, double price) {
        medicineStock.put(medicineName, stock);
        medicinePrices.put(medicineName, price);
    }

    public List<String> getAvailableSalts(String medicineName) {
        List<String> availableSalts = new ArrayList<>();
        // Logic to retrieve available salts based on the medicine name
        // Assuming salts are stored in the saltStock and saltPrices maps
        for (String salt : saltStock.keySet()) {
            if (saltStock.get(salt) > 0) {
                availableSalts.add(salt);
            }
        }
        return availableSalts;
    }

    public boolean isSaltAvailable(String salt) {
        return saltStock.containsKey(salt) && saltStock.get(salt) > 0;
    }

    public double getSaltPrice(String salt) {
        return saltPrices.get(salt);
    }

    public void addSalt(String salt, int stock, double price) {
        saltStock.put(salt, stock);
        saltPrices.put(salt, price);
    }
}