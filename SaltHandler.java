package sdps.Quiz3;

import java.util.List;

interface SaltHandler {
    boolean handleSalt(String medicineName);
    void setNextHandler(SaltHandler nextHandler);
}
