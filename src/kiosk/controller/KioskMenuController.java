package kiosk.controller;

import kiosk.service.KioskMenuInventoryService;
import kiosk.service.KioskMenuOrderService;
import kiosk.service.KioskMenuService;
import menu.model.Menu;

import java.util.List;
import java.util.Scanner;

public class KioskMenuController {

    private List<Menu> menuList;
    private final Scanner scanner;
    private final KioskMenuService kioskMenuService;
    private final KioskMenuInventoryService kioskMenuInventoryService;
    private final KioskMenuOrderService kioskMenuOrderService;

    public KioskMenuController(Scanner scanner, KioskMenuService kioskMenuService, KioskMenuInventoryService kioskMenuInventoryService,
                               KioskMenuOrderService kioskMenuOrderService, List<Menu> menuList) {
        this.scanner = scanner;
        this.kioskMenuService = kioskMenuService;
        this.kioskMenuInventoryService = kioskMenuInventoryService;
        this.kioskMenuOrderService = kioskMenuOrderService;
        this.menuList = menuList;

        if (this.kioskMenuInventoryService == null) {
            throw new IllegalArgumentException("KioskMenuInventoryService cannot be null");
        }
    }

    public void displayMenu() {
        kioskMenuService.displayMenu();
    }

    public void processMenuChoice() {
        int choice = getChoiceFromUser();
        switch (choice) {
            case 1:
                order();
                break;
            case 2:
                viewMenu();
                break;
            case 3:
                checkOut();
                break;
            case 4:
                exit();
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }

    private int getChoiceFromUser() {
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    private void order() {
        System.out.println("Processing order...");
        List<Menu> selectedMenus = kioskMenuOrderService.getOrderList();
        kioskMenuService.displayOrderSummary(selectedMenus);
        kioskMenuInventoryService.updateInventory(selectedMenus);
        kioskMenuService.displayThankYouMessage();
    }

    private void viewMenu() {
        System.out.println("Displaying menu...");
        kioskMenuService.displayMenu();
    }

    private void checkOut() {
        System.out.println("Checking out...");
        // Add logic for checking out
    }

    private void exit() {
        System.out.println("Exiting Kiosk. Thank you for using our services!");
        System.exit(0);
    }

    // Inside KioskMenuController class
    public void placeOrder() {

    }
}


