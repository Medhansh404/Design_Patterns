// CompoundOrderStrategy class
package sdps.Quiz3;

import java.util.List;

class CompoundOrderStrategy implements OrderStrategy {
    @Override
    public OrderResult processOrder(String medicineName, List<String> availableSalts) {
        SaltComposer saltComposer = new SaltComposer();
        return saltComposer.composeOrder(medicineName, availableSalts);
    }
}