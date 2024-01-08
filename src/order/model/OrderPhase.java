package order.model;

public enum OrderPhase {
    TAKE_OUT("포장"),
    DINE_IN("매장 식사"),
    DELIVERY("배달");

    private final String description;

    OrderPhase(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
