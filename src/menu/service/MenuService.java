package menu.service;

import category.MenuCategory;
import menu.model.Menu;
import shakeshack.Burger;
import shakeshack.Drink;
import shakeshack.ForzenCustard;
import shakeshack.ShakeShackPatty;

import java.util.ArrayList;
import java.util.List;

public class MenuService {

    private List<Menu> menuList;
    public List<Menu> findMenu() {
        return List.of(MenuCategory.Burger, MenuCategory.ForzenCustard, MenuCategory.Drink, MenuCategory.Beer);
    }

    public int getMenuSize() {
        return List.of(MenuCategory.Burger, MenuCategory.ForzenCustard, MenuCategory.Drink, MenuCategory.Beer).size();
    }

    public void displayMenu(int menuId) {
        Menu menu = createMenu(menuId);
        System.out.println(menu.getMenuId() + ". " + menu.getMenuName() + " | " + menu.getMenuDescription());
    }

    private Menu createMenu(int menuId) {
        // You can add more cases for different menu items
        switch (menuId) {
            case 1:
                return new Burger(1, "Burgers", "앵거스 비프 통살을 다져만든 버거", 10, ShakeShackPatty.PattyType.SINGLE);
            case 2:
                return new ForzenCustard(2, "Forzen Custard", "매장에서 신선하게 만드는 아이스크림", 5, ShakeShackPatty.PattyType.SINGLE);
            case 3:
                return new Drink(3, "Drinks", "매장에서 직접 만드는 음료", 2, ShakeShackPatty.PattyType.SINGLE);
            // Add more cases as needed
            default:
                throw new IllegalArgumentException("Invalid menuId: " + menuId);
        }
    }

    public Menu getMenu(int menuId) {
        // Find the menu with the specified ID in menuList
        for (Menu menu : menuList) {
            if (menu.getMenuId() == menuId) {
                return menu;  // Return the menu if found
            }
        }

        return null;
    }
}
