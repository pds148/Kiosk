
import kiosk.controller.KioskMenuController;
import kiosk.service.KioskMenuInventoryService;
import kiosk.service.KioskMenuOrderService;
import kiosk.service.KioskMenuService;
import menu.model.Menu;
import menu.service.MenuService;
import order.service.OrderService;
import product.service.ProductService;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KioskMain {
    public static void main(String[] args) throws InterruptedException, NoSuchAlgorithmException {
        List<Menu> menuList = new ArrayList<>();  // Create an empty list of menus

        menuList.add(new Menu(1, "Menu1", "Description1", 10));
        menuList.add(new Menu(2, "Menu2", "Description2", 15));

        Scanner scanner = new Scanner(System.in);
        KioskMenuService kioskMenuService = new KioskMenuService(menuList);
        OrderService orderService = new OrderService();
        MenuService menuService = new MenuService();
        ProductService productService = new ProductService();
        KioskMenuInventoryService kioskMenuInventoryService = new KioskMenuInventoryService(orderService, menuService, productService);
        KioskMenuOrderService kioskMenuOrderService = new KioskMenuOrderService(menuList);
        KioskMenuController kioskMenuController = new KioskMenuController(scanner, kioskMenuService, kioskMenuInventoryService, kioskMenuOrderService, menuList);

        
        
        kioskMenuController.displayMenu();
        kioskMenuController.processMenuChoice();


        System.out.println("Welcome to the Kiosk!");

        boolean exit = false;
        while (!exit) {
            // Display menu options or perform other actions as needed
            System.out.println("1. Display Menu");
            System.out.println("2. Place Order");
            System.out.println("3. Exit");

            // Get user input
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    kioskMenuController.displayMenu();
                    break;
                case 2:
                    kioskMenuController.placeOrder();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Thank you for using the Kiosk!");
    }
}

