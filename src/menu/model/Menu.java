package menu.model;

public class Menu {

    private final int menuId;

    private final String menuName;

    private final String menuDescription;

    private final int price;



    public Menu(int menuId, String menuName, String menuDescription, int price) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuDescription = menuDescription;
        this.price = price;
    }

    public int getMenuId() {
        return menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public String getMenuDescription() {
        return menuDescription;
    }

    public int getPrice() {
        return price;
    }

    public void displayMenu() {
        System.out.println(menuId + ". " + menuName + "   | W " + price + " | " + menuDescription);
    }
}
