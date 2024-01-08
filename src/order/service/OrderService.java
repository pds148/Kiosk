package order.service;

import order.model.Order;
import menu.model.Menu;
import product.model.Product;

import java.util.List;

public class OrderService {

    static int orderId = 1;

    public void cancelOrder(Order order) {
        order.getMenuMap().clear();
        order.getMenus().clear();
    }

    public int calculateTotalPrice(Order order) {
        return order.calculateTotalPrice();
    }

    public Order initializeOrder(int quantity, int price) {
        Order order = new Order(orderId++, quantity, price);
        return order;
    }

    public Order addTakeOutService(Order order, Menu takeOutService) {
        order.addMenu(takeOutService);
        order.addMenuMap(takeOutService);
        return order;
    }

    public Order getCurrentOrder() {
        return null;
    }
}


