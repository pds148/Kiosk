package shakeshack;

import menu.model.Menu;

public class Drink extends Menu {

    private final int menuId;

    private final String menuName;

    private final String menuDescription;

    private final int price;

    private ShakeShackPatty patty;


    public Drink(int menuId, String menuName, String menuDescription, int price, ShakeShackPatty.PattyType pattyType) {
        super(menuId, menuName, menuDescription, price);
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuDescription = menuDescription;
        this.price = price;
        this.patty = new ShakeShackPatty(pattyType);
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

    public ShakeShackPatty getPatty() {
        return patty;
    }

    public void setPatty(ShakeShackPatty.PattyType pattyType) {
        this.patty = new ShakeShackPatty(pattyType);
    }
}
