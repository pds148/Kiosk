package product.model;

import order.model.Order;

import java.util.List;

public class Product {

    private final List<Order> orderList;

    public Product(List<Order> orderList) {
        this.orderList = orderList;
    }

    public int calculateTotalPrice() {
        int totalPrice = 0;
        for (Order order : orderList) {
            totalPrice += order.calculateTotalPrice();
        }
        return totalPrice;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void addOrder(Order order) {
        orderList.add(order);
    }

    public void removeOrder(Order order) {
        orderList.remove(order);
    }

    public void clear() {
        orderList.clear();
    }
}

