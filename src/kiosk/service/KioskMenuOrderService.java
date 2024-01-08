package kiosk.service;

import java.util.ArrayList;
import java.util.List;
import menu.model.Menu;
import util.validation.InputValidator;

public class KioskMenuOrderService {

    private List<Menu> orderList = new ArrayList<>();

    public KioskMenuOrderService(List<Menu> orderList) {
        this.orderList = orderList;
    }

    public void displayMenu() {
        line();
        System.out.println("메뉴를 선택해주세요:");
        for (int i = 0; i < orderList.size(); i++) {
            Menu menu = orderList.get(i);
            System.out.printf("%d. %s - %s원\n", i + 1, menu.getMenuName(), menu.getPrice());
        }
    }

    private void line() {
        InputValidator.printLine();
    }

    public void takeOrder() {
        line();
        System.out.println("주문할 제품 번호를 입력해주세요 (0. 주문 완료):");
        int menuNumber;
        do {
            menuNumber = InputValidator.getValidInput(0, orderList.size());
            if (menuNumber != 0) {
                // Process the selected menu (e.g., add to the order)
                // You can implement the order processing logic here
                System.out.printf("%s를 주문하셨습니다.\n", orderList.get(menuNumber - 1).getMenuName());
            }
        } while (menuNumber != 0);
    }

    private void addToOrder(Menu menu) {
        orderList.add(menu);
    }

    public List<Menu> getOrderList() {
        return orderList;
    }

    public void displayOrderConfirmation() {
        // ... (existing code)
        // Display the ordered items from the orderList
        System.out.println("주문 내역:");
        for (Menu menu : orderList) {
            System.out.printf("%s\n", menu.getMenuName());
        }
        System.out.println("주문이 완료되었습니다. 감사합니다!");
    }
}


