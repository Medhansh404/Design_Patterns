// OrderResult class
package sdps.Quiz3;
class OrderResult {
    private boolean successful;
    private String message;
    private double price;

    private OrderResult(boolean successful, String message, double price) {
        this.successful = successful;
        this.message = message;
        this.price = price;
    }

    public static OrderResult successful(double price) {
        return new OrderResult(true, "Order successful", price);
    }

    public static OrderResult unavailable() {
        return new OrderResult(false, "Order unavailable", 0.0);
    }

    public static OrderResult failed(String message) {
        return new OrderResult(false, message, 0.0);
    }

    public boolean isSuccessful() {
        return successful;
    }

    public String getMessage() {
        return message;
    }

    public double getPrice() {
        return price;
    }
}