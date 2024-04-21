package sdps.Quiz3;

class CompoundSaltHandler implements SaltHandler {
    private SaltHandler nextHandler;

    @Override
    public void setNextHandler(SaltHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public boolean handleSalt(String medicineName) {
        // Handle the salt or delegate to the next handler
        if (nextHandler != null) {
            return nextHandler.handleSalt(medicineName);
        } else {
            // If no handler is able to process
            return false;
        }
    }

    // Additional method to check availability
    public boolean checkAvailability(String medicineName) {
        // Check availability logic
        // Here you can check if the compound medicine is available
        return false; // Placeholder for implementation
    }
}
