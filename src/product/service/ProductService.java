package product.service;

import menu.model.Menu;
import order.model.Order;
import product.model.Product;

import java.util.List;

public class ProductService {

    public Order findByOrderId(List<Order> orders, int orderId) {
        return orders.stream()
                .filter(order -> order.getId() == orderId)
                .findFirst()
                .orElse(null);
    }

    public List<Menu> getMenuListByOrderId(List<Order> orders, int orderId) {
        Order order = findByOrderId(orders, orderId);
        if (order != null) {
            return order.getMenus();
        }
        return null;
    }

    public int getTotalPriceByOrderId(List<Order> orders, int orderId) {
        Order order = findByOrderId(orders, orderId);
        if (order != null) {
            return order.calculateTotalPrice();
        }
        return 0;
    }

    public void clearProductOrders(List<Product> products) {
        for (Product product : products) {
            product.clear();
        }
    }
}


