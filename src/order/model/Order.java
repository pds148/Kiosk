package order.model;

import menu.model.Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Order {

    private int id;
    private final List<Menu> menus = new ArrayList<>();
    private final HashMap<Menu, Integer> menuMap = new HashMap<>();
    private int quantity;
    private OrderPhase orderPhase;

    public Order(int id, int quantity, int price) {
        this.id = id;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public HashMap<Menu, Integer> getMenuMap() {
        return menuMap;
    }

    public void addMenu(Menu menu) {
        this.menuMap.merge(menu, 1, Integer::sum);
    }

    public void addMenuMap(Menu item) {
        menuMap.merge(item, 1, Integer::sum);
    }

    public String getOrderPhase() {
        return orderPhase.getDescription();
    }

    public int calculateTotalPrice() {
        int totalPrice = 0;
        for (Menu menu : menus) {
            totalPrice += menu.getPrice();
        }
        return totalPrice * quantity;
    }


    public HashMap<Menu, Integer> getMenuQuantityMap() {
        return menuMap;
    }
}