package kiosk.service;

import menu.model.Menu;
import menu.service.MenuService;
import order.model.Order;
import order.model.OrderPhase;
import order.service.OrderService;
import product.model.Product;
import product.service.ProductService;
import shakeshack.Burger;
import util.validation.InputValidator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class KioskMenuInventoryService {

    private final OrderService orderService;
    private final MenuService menuService;
    private final ProductService productService;
    private final Map<Menu, Integer> orderItemsCount = new HashMap<>();

    public KioskMenuInventoryService(OrderService orderService, MenuService menuService, ProductService productService) {
        this.orderService = orderService;
        this.menuService = menuService;
        this.productService = productService;
    }

    public void displayMainMenu() {
        System.out.println("SHAKESHACK BURGER에 오신걸 환영합니다.");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        System.out.println("\n[ SHAKESHACK MENU ]");

        // Displaying at least 3 product menus
        displayMenus(1, 2, 3);

        System.out.println("\n[ ORDER MENU ]");
        System.out.println("5. Order       | 장바구니를 확인 후 주문합니다.");
        System.out.println("6. Cancel      | 진행중인 주문을 취소합니다.");

        Menu burgerMenu = menuService.getMenu(1);
        Menu custardMenu = menuService.getMenu(2);
        Menu drinkMenu = menuService.getMenu(3);

        displayPurchaseScreen(burgerMenu);
        displayPurchaseScreen(custardMenu);
        displayPurchaseScreen(drinkMenu);
    }

    // Additional method to handle user input for menu selection
    public int getUserMenuSelection() {
        System.out.println("\n메뉴를 선택하세요: ");
        return InputValidator.getValidInput(1, 6);
    }

    public void displayProductMenu() {
        System.out.println("SHAKESHACK BURGER에 오신걸 환영합니다.");
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
        System.out.println("\n[ Burgers MENU ]");

        // Displaying burgers menu
        displayMenus(1, 2, 3, 4, 5);

        System.out.println("\n[ ORDER MENU ]");
        System.out.println("6. Order       | 장바구니를 확인 후 주문합니다.");
        System.out.println("7. Cancel      | 진행중인 주문을 취소합니다.");
    }

    public int getUserProductSelection() {
        System.out.println("\n상품을 선택하세요: ");
        return InputValidator.getValidInput(1, 7);
    }

    public void displayPurchaseScreen(Menu menu) {
        System.out.println("\n" + menu.getMenuName() + " | W " + menu.getPrice() / 10.0 +
                " | " + menu.getMenuDescription());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소");

        int userChoice = InputValidator.getValidInput(1, 2);

        if (userChoice == 1) {
            System.out.println(menu.getMenuName() + " 가 장바구니에 추가되었습니다.");
            // You may want to add the selected menu to the order or cart here
        } else {
            System.out.println("장바구니에 추가를 취소하였습니다.");
        }
    }

    // Additional method to handle user input for order completion
    public void completeOrder() {
        System.out.println("\n1. 주문");
        System.out.println("2. 취소");

        int userChoice = InputValidator.getValidInput(1, 2);

        if (userChoice == 1) {
            Order order = orderService.initializeOrder(1, 0); // Adjust the parameters as needed
            displayOrderCompletionScreen(order);
        } else {
            System.out.println("주문이 취소되었습니다.");
        }
    }

    public void displayOrderCompletionScreen(Order order) {
        System.out.println("\n주문이 완료되었습니다!");
        System.out.println("대기번호는 [ " + order.getId() + " ] 번 입니다.");
        System.out.println("(3초후 메뉴판으로 돌아갑니다.)");

        try {
            Thread.sleep(3000); // Sleep for 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Return to the main menu
        displayMainMenu();
    }

    private void displayMenus(int... menuIds) {
        for (int menuId : menuIds) {
            menuService.displayMenu(menuId);
        }
    }

    public void updateInventory(List<Menu> selectedMenus) {
        // Add logic to update inventory based on the list of selected menus
        // ...
    }

    public void displayOrderScreen() {
        System.out.println("\n[ Orders ]");

        // Display ordered items with their count
        for (Map.Entry<Menu, Integer> entry : orderItemsCount.entrySet()) {
            Menu menu = entry.getKey();
            int count = entry.getValue();
            System.out.println(menu.getMenuName() + "   | W " + menu.getPrice() / 10.0 + " | " + count + "개 | " + menu.getMenuDescription());
        }

        System.out.println("\n[ Total ]");
        System.out.println("W " + calculateTotalPrice() / 10.0);

        System.out.println("\n1. 주문      2. 메뉴판  3. 주문 개수 조회  4. 상품 옵션 추가  5. 총 판매금액 조회  6. 총 판매상품 목록 조회");
    }

    private int calculateTotalPrice() {
        int totalPrice = 0;
        for (Map.Entry<Menu, Integer> entry : orderItemsCount.entrySet()) {
            Menu menu = entry.getKey();
            int count = entry.getValue();
            totalPrice += menu.getPrice() * count;
        }
        return totalPrice;
    }

    public void addToOrder(Menu menu) {
        if (orderItemsCount.containsKey(menu)) {
            orderItemsCount.put(menu, orderItemsCount.get(menu) + 1);
        } else {
            orderItemsCount.put(menu, 1);
        }

        System.out.println(menu.getMenuName() + " 가 장바구니에 추가되었습니다.");
    }

    public void displayOrderCount() {
        System.out.println("\n[ Orders ]");

        // Display ordered items with their count
        for (Map.Entry<Menu, Integer> entry : orderItemsCount.entrySet()) {
            Menu menu = entry.getKey();
            int count = entry.getValue();
            System.out.println(menu.getMenuName() + "   | " + count + "개");
        }

        System.out.println("\n1. 주문      2. 메뉴판  3. 주문 개수 조회  4. 상품 옵션 추가  5. 총 판매금액 조회  6. 총 판매상품 목록 조회");
    }

    public void displayTotalSalesAmount() {
        System.out.println("\n[ 총 판매금액 현황 ]");
        System.out.println("현재까지 총 판매된 금액은 [ W " + calculateTotalPrice() / 10.0 + " ] 입니다.");
        System.out.println("\n1. 돌아가기");
    }

    public void displayTotalSoldProducts() {
        System.out.println("\n[ 총 판매상품 목록 현황 ]");

        // Display ordered items
        for (Map.Entry<Menu, Integer> entry : orderItemsCount.entrySet()) {
            Menu menu = entry.getKey();
            int count = entry.getValue();
            System.out.println("- " + menu.getMenuName() + "   | W " + menu.getPrice() / 10.0 + " | " + count + "개");
        }

        System.out.println("\n1. 돌아가기");
    }
}
