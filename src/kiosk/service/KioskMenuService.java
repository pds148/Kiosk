package kiosk.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import menu.model.Menu;
import util.validation.InputValidator;

public class KioskMenuService {

    private final List<Menu> menus;
    KioskMenuOrderService kioskMenuOrderService;
    KioskMenuInventoryService kioskMenuInventoryService;

    private final Scanner scanner;

    public KioskMenuService(List<Menu> menus, KioskMenuOrderService kioskMenuOrderService, KioskMenuInventoryService kioskMenuInventoryService) {
        this.menus = menus;
        this.kioskMenuOrderService = kioskMenuOrderService;
        this.kioskMenuInventoryService = kioskMenuInventoryService;
        this.scanner = new Scanner(System.in);
    }


    public KioskMenuService(List<Menu> menus) {
        this.menus = menus;
        this.scanner = new Scanner(System.in);
    }



    public void displayMenu() {
        InputValidator.printLine();
        System.out.println("======== 메뉴 ========");

        for (Menu menu : menus) {
            System.out.printf("%d. %s - %d원\n", menu.getMenuId(), menu.getMenuName(), menu.getPrice());
        }

        InputValidator.printLine();
    }

    public Menu selectMenuById() {
        int menuId;

        do {
            System.out.println("메뉴 번호를 입력하세요: ");
            menuId = InputValidator.getValidInput(1, menus.size());
            if (selectMenuById(menuId) == null) {
                System.out.println("[ 잘못된 메뉴 번호입니다. ]");
            }
        } while (selectMenuById(menuId) == null);

        return selectMenuById(menuId);
    }

    private Menu selectMenuById(int menuId) {
        for (Menu menu : menus) {
            if (menu.getMenuId() == menuId) {
                return menu;
            }
        }
        return null;
    }

    public void displayOrderSummary(List<Menu> selectedMenus) {
        InputValidator.printLine();
        System.out.println("======== 주문 내역 ========");

        int totalAmount = 0;
        for (Menu menu : selectedMenus) {
            System.out.printf("%s - %d원\n", menu.getMenuName(), menu.getPrice());
            totalAmount += menu.getPrice();
        }

        System.out.printf("총 주문 금액: %d원\n", totalAmount);
        InputValidator.printLine();
    }

    public List<Menu> selectMenusById() {
        List<Menu> selectedMenus = new ArrayList<>();
        int numberOfItemsToOrder = getNumberOfItemsToOrder(); // You can implement this method to get the number of items the user wants to order

        for (int i = 0; i < numberOfItemsToOrder; i++) {
            int menuId;
            do {
                System.out.println("메뉴 번호를 입력하세요: ");
                menuId = InputValidator.getValidInput(1, menus.size());
                Menu selectedMenu = selectMenuById(menuId);
                if (selectedMenu == null || selectedMenus.contains(selectedMenu)) {
                    System.out.println("[ 잘못된 메뉴 번호이거나 이미 선택된 메뉴입니다. ]");
                } else {
                    selectedMenus.add(selectedMenu);
                    break;
                }
            } while (true);
        }

        return selectedMenus;
    }


    private int getNumberOfItemsToOrder() {
        System.out.print("Enter the number of items to order: ");
        return scanner.nextInt();
    }

    public void displayThankYouMessage() {
        System.out.println("주문이 완료되었습니다. 감사합니다!");
    }

}

