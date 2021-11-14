public class Status {
    Boolean available;
    String returnDate;

    public Status(Boolean available, String returnDate) {
        this.available = available;
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        if (available) {
            return "Available for loan.";
        } else {
            return "Unavailable for loan until: " + returnDate;
        }
    }
}
